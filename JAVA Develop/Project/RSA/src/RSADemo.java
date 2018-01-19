import java.security.*;  
import java.security.spec.*;  
import java.security.interfaces.*;  
import javax.crypto.spec.*;  
import javax.crypto.interfaces.*;  
import java.io.*;  
import java.math.*;  
public class RSADemo {  
    public RSADemo() {  
    }  
    public static void generateKey() {  
        try {  
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");  
            kpg.initialize(1024);  
            KeyPair kp = kpg.genKeyPair();  
            PublicKey pbkey = kp.getPublic();  
            PrivateKey prkey = kp.getPrivate();  
            // ���湫Կ  
            FileOutputStream f1 = new FileOutputStream("pubkey.dat");  
            ObjectOutputStream b1 = new ObjectOutputStream(f1);  
            b1.writeObject(pbkey);  
            // ����˽Կ  
            FileOutputStream f2 = new FileOutputStream("privatekey.dat");  
            ObjectOutputStream b2 = new ObjectOutputStream(f2);  
            b2.writeObject(prkey);  
        } catch (Exception e) {  
        }  
    }  
    public static void encrypt() throws Exception {  
        String s = "Hello World!";  
        // ��ȡ��Կ������e,n  
        FileInputStream f = new FileInputStream("pubkey.dat");  
        ObjectInputStream b = new ObjectInputStream(f);  
        RSAPublicKey pbk = (RSAPublicKey) b.readObject();  
        BigInteger e = pbk.getPublicExponent();  
        BigInteger n = pbk.getModulus();  
        System.out.println("e= " + e);  
        System.out.println("n= " + n);  
        // ��ȡ����m  
        byte ptext[] = s.getBytes("UTF-8");  
        BigInteger m = new BigInteger(ptext);  
        // ��������c  
        BigInteger c = m.modPow(e, n);  
        System.out.println("c= " + c);  
        // ��������  
        String cs = c.toString();  
        BufferedWriter out =  
            new BufferedWriter(  
                new OutputStreamWriter(new FileOutputStream("encrypt.dat")));  
        out.write(cs, 0, cs.length());  
        out.close();  
    }  
    public static void decrypt() throws Exception {  
        // ��ȡ����  
        BufferedReader in =  
            new BufferedReader(  
                new InputStreamReader(new FileInputStream("encrypt.dat")));  
        String ctext = in.readLine();  
        BigInteger c = new BigInteger(ctext);  
        // ��ȡ˽Կ  
        FileInputStream f = new FileInputStream("privatekey.dat");  
        ObjectInputStream b = new ObjectInputStream(f);  
        RSAPrivateKey prk = (RSAPrivateKey) b.readObject();  
        BigInteger d = prk.getPrivateExponent();  
        // ��ȡ˽Կ����������  
        BigInteger n = prk.getModulus();  
        System.out.println("d= " + d);  
        System.out.println("n= " + n);  
        BigInteger m = c.modPow(d, n);  
        // ��ʾ���ܽ��  
        System.out.println("m= " + m);  
        byte[] mt = m.toByteArray();  
        System.out.println("PlainText is ");  
        for (int i = 0; i < mt.length; i++) {  
            System.out.print((char) mt[i]);  
        }  
    }  
    public static void main(String args[]) {  
        try {  
            generateKey();  
            encrypt();  
            decrypt();  
        } catch (Exception e) {  
            System.out.println(e.toString());  
        }  
    }  
}  