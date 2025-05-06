import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class criptografiaS {
    public static void main(String[] args) throws Exception {
        String mensagem = "Mensagem secreta com AES";

        // Geração da chave
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey chave = keyGen.generateKey();

        // Criptografar
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] mensagemCriptografada = cipher.doFinal(mensagem.getBytes());
        String mensagemCriptografadaBase64 = Base64.getEncoder().encodeToString(mensagemCriptografada);

        // Descriptografar
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] mensagemDescriptografada = cipher.doFinal(Base64.getDecoder().decode(mensagemCriptografadaBase64));
        String mensagemOriginal = new String(mensagemDescriptografada);

        // Exibir
        System.out.println("Mensagem original: " + mensagem);
        System.out.println("Criptografada (Base64): " + mensagemCriptografadaBase64);
        System.out.println("Descriptografada: " + mensagemOriginal);
    }
}
