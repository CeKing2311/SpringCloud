import sun.applet.Main;

import java.time.ZonedDateTime;

/*
 *@author ceking
 *@description
 *@date 2021-1-25 17:32
 */
public class Test {
    public static void main(String[] args) {
        ZonedDateTime zdt =ZonedDateTime.now();//默认时区
        System.out.println(zdt);
    }
}
