import java.security.*;

public class AssDigital {
    public static void main(String[] args) throws Exception {
        String mensagem = "Mensagem a ser assinada";

        //chaves
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair chave = keyGen.generateKeyPair();

        // Assinar com a chave privada
        Signature assinatura = Signature.getInstance("SHA256withRSA");
        assinatura.initSign(chave.getPrivate());
        assinatura.update(mensagem.getBytes());
        byte[] assinaturaBytes = assinatura.sign();

        // Verificar com a chave pública
        Signature verificador = Signature.getInstance("SHA256withRSA");
        verificador.initVerify(chave.getPublic());
        verificador.update(mensagem.getBytes());
        boolean valida = verificador.verify(assinaturaBytes);

       
        System.out.println("Mensagem: " + mensagem);
        System.out.println("Assinatura válida? " + valida);
    }
}
