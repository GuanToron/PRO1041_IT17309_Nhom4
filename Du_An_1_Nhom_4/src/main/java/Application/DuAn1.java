

package Application;


import Service.Implement.KhachHangServiceImplement;
import View.FormSanPhamLoi;
import View.Formkh;
import View.MainApp;


public class DuAn1 {

    public static void main(String[] args) {
         new KhachHangServiceImplement().listKH().forEach(s->System.out.println(s.toString()));
    }
}
