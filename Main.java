import java.util.Scanner;

public class Main
{
    public static String encrypt(String originalText,String key)
    {

        char[] textChar=new char[150];
        textChar=originalText.toCharArray();
        char[] keyChar=new char[150];
        keyChar = key.toCharArray();

        int i,j;
        int originalText_length=originalText.length();
        int key_length=key.length();

        char[] yeniAnahtar=new char[originalText_length];
        char[] encrypted=new char[originalText_length];
        for (i = 0,j=0; i <originalText_length ;i++,j++)
        {
            if(j==key_length)
            {
                j=0;
            }
            yeniAnahtar[i]=keyChar[j];
        }
        System.out.println(yeniAnahtar);
        for (i=0; i <originalText_length;i++)
        {
            encrypted[i]=(char)(((textChar[i]+yeniAnahtar[i])%26+1)+'A');
        }
        System.out.println("Şifrelenmiş Mesaj: "+String.valueOf(encrypted));

        return originalText;
    }
    public static String toUpperString(String text)
    {
        String str1=text.toUpperCase();
        return str1;
    }
    public static String decrypt(String encryptedText,String key)
    {

        int mesaj_uzunluk=encryptedText.length();
        char[] textChar=new char[150];
        char[]keyChar=new char[150];
        textChar = encryptedText.toCharArray();
        keyChar = key.toCharArray();
        keyChar=key.toCharArray();
        char[]decrypted=new char[mesaj_uzunluk];

        int i,j;
        int originalText_length=encryptedText.length();
        int key_length=key.length();

        char[] yeniAnahtar=new char[originalText_length];
        char[] encrypted=new char[originalText_length];

        for (i = 0,j=0; i <originalText_length ;i++,j++)
        {
            if(j==key_length)
            {
                j=0;
            }
            yeniAnahtar[i]=keyChar[j];
        }
        System.out.println(yeniAnahtar);
        for (i = 0; i<mesaj_uzunluk ; i++)
        {
            encrypted[i]+=(char)(((textChar[i]+yeniAnahtar[i])%26+1)+'A');
        }
        for(i = 0; i <mesaj_uzunluk; ++i)
        {
            decrypted[i] = (char) ((((encrypted[i] - yeniAnahtar[i]) + 26-1) % 26) + 'A');
        }
        System.out.println("Şifresi Kırılmış Mesaj: " + String.valueOf(decrypted));

        return encryptedText;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Mesaj:");
        String mesaj=scanner.nextLine();
        System.out.print("Key:");
        String key=scanner.nextLine();

        String encryptedText=encrypt(toUpperString(mesaj),toUpperString(key));//burada encryptedText e atama yaparken encryptli halini bastırmış oluyor(metodu çağırmış olduk.)
        decrypt(toUpperString(encryptedText),toUpperString(key));//burada da decrypt metodunu çağırarak çıktıyı alıyoruz.//
    }
}
