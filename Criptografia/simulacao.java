import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class simulacao {
    public static void main(String[] args) throws Exception {
        String mensagem = "Oi Facens";

        //chaves 
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);

        KeyPair chaveAluno = keyGen.generateKeyPair();
        KeyPair chaveFacens = keyGen.generateKeyPair();

        // Aluno criptografa a mensagem com a chave pública do Facens
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, chaveFacens.getPublic());
        byte[] mensagemCriptografada = cipher.doFinal(mensagem.getBytes());

        // Aluno assina com sua chave privada
        Signature assinatura = Signature.getInstance("SHA256withRSA");
        assinatura.initSign(chaveAluno.getPrivate());
        assinatura.update(mensagem.getBytes());
        byte[] assinaturaBytes = assinatura.sign();

        // Facens descriptografa com sua chave privada
        cipher.init(Cipher.DECRYPT_MODE, chaveFacens.getPrivate());
        byte[] mensagemDescriptografada = cipher.doFinal(mensagemCriptografada);
        String mensagemRecebida = new String(mensagemDescriptografada);

        // Facens verifica a assinatura com a chave pública da Aluno
        Signature verificador = Signature.getInstance("SHA256withRSA");
        verificador.initVerify(chaveAluno.getPublic());
        verificador.update(mensagemDescriptografada);
        boolean assinaturaValida = verificador.verify(assinaturaBytes);

       
        System.out.println("Mensagem recebida por Facens: " + mensagemRecebida);
        System.out.println("Assinatura válida? " + assinaturaValida);
    }
}
