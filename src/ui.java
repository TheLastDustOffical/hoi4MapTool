import java.util.Scanner;
public class ui {

    public static String tag;
    public static String repTag;

    public static void Ui() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Hoi4MapTool  v.0.0.1  Devolopt by TheLastDust");
        System.out.println("");
        System.out.println("Please enter the country tag: ");

        tag = scan.next();

        //String[] taggg = new String[] { "SWI", "YEM", "OMA"};
        //String tag = taggg.toString();

        finder objektZweite = new finder();
        objektZweite.find();

        replace objektDritte = new replace();
        objektDritte.replacer();


    }
    public static String getTag() {
        return tag;
    }





}
