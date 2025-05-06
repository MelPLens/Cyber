import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class criptografiaA {
    public static void main(String[] args) throws Exception {
        String mensagem = "Mensagem secreta com RSA";

        // chaves
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair chave = keyGen.generateKeyPair();

        // Criptografar 
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, chave.getPublic());
        byte[] mensagemCriptografada = cipher.doFinal(mensagem.getBytes());
        String mensagemCriptografadaBase64 = Base64.getEncoder().encodeToString(mensagemCriptografada);

        // Descriptografar 
        cipher.init(Cipher.DECRYPT_MODE, chave.getPrivate());
        byte[] mensagemDescriptografada = cipher.doFinal(Base64.getDecoder().decode(mensagemCriptografadaBase64));
        String mensagemOriginal = new String(mensagemDescriptografada);

       
        System.out.println("Mensagem original: " + mensagem);
        System.out.println("Criptografada (Base64): " + mensagemCriptografadaBase64);
        System.out.println("Descriptografada: " + mensagemOriginal);
    }
}
