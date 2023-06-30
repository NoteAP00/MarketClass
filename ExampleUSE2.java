/**
 * @author Apinun Umbao
 * ID 6303051623195
 */
import java.util.Scanner;


public class ExampleUSE2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        MarketClass MC = new MarketClass();
        boolean wNum = true;
        int key = -1;
        int loop = 0;
        System.out.println("โปรแกรมระบบร้านค้า");
        System.out.println("ระบบนี้มีการเพิ่มรายการสินค้าตัวอย่างไว้แล้วดังนี้");
        String [][]exGoods = {        {"น้ำดื่ม : น้ำทิพย์ (550ml)","100000","7"},
                                      {"น้ำดื่ม : คริสตัล (600ml)","100000","6"},
                                      {"น้ำดื่ม : ช้าง (600ml)","100000","7"},
                                      {"บะหมี่กึ่งสำเร็จรูป : มาม่า ต้มยำกุ้ง ","100000","10"},
                                      {"บะหมี่กึ่งสำเร็จรูป : มาม่า หมูสับ ","100000","10"},
                                      {"บะหมี่กึ่งสำเร็จรูป : ยำยำ ต้มยำกุ้ง ","100000","10"},
                                      {"บะหมี่กึ่งสำเร็จรูป : ยำยำ หมูสับ ","100000","10"},
                                      {"บะหมี่กึ่งสำเร็จรูป : นิสชิน ซุปต้มกระดูกหมู ","100000","10"},
                                      {"บะหมี่กึ่งสำเร็จรูป : นิสชิน ไก่เผ็ดเกาหลี ","100000","10"},
                                      {"บะหมี่กึ่งสำเร็จรูป : นิสชิน ต้มยำกุ้ง ","100000","10"},
                                      {"เครื่องเขียน : Double A A4 80 แกรม 500 แผ่น ","100000","112"},
                                      {"เครื่องเขียน : Idea MAX A4 70 แกรม 500 แผ่น ","100000","101"},
                                      {"เครื่องเขียน : สก๊อตช์ เทปเยื่อกาว 2 หน้า 12มม. x 10 หลา ","100000","30"},
                                      {"เครื่องเขียน : แลนเซอร์ สไปรัล ปากกาลูกลื่น สีน้ำเงิน 3 ด้าม ","100000","20"},
                                      {"เครื่องเขียน : แลนเซอร์ สไปรัล ปากกาลูกลื่น สีแดง 3 ด้าม ","100000","20"},
                                      {"เครื่องเขียน : ยู้ฮู กาวซุปเปอร์กลูจัมโบ้ กาวพลังช้าง 3กรัม ","100000","30"},
                                      {"เครื่องเขียน : ควอนตั้ม ดินสอดำ 2B 6 แท่ง ","100000","25"},
                                      {"เครื่องเขียน : โพสต์-อิท โน้ต กระดาษโน้ตชนิดมีกาว ขนาด 3 x 3 นิ้ว 100 แผ่น x 4 เล่ม ","100000","165"},
                                      {"ทำความสะอาด : ซันไลต์ เลมอน เทอร์โบ น้ำยาล้างจาน (150ml) ","100000","12"},
                                      {"ทำความสะอาด : ซันไลต์ เนเจอร์ ผลิตภัณฑ์ล้างจาน (145ml) ","100000","12"}};
        for (int i = 0; i < exGoods.length; i++) {
            MC.addGoods(exGoods[i][0],Integer.parseInt(exGoods[i][1]), Integer.parseInt(exGoods[i][2]));
        }
        System.out.println(MC.listGoods());
        while (true) {
            wNum = true;
            System.out.println(MC.Menu0());
            do {
            try{
                    System.out.print("เลือกคำสั่งที่ : ");    
                    key = kb.nextInt();
                    wNum = false;
            }
            catch(Exception e){
                    System.out.println("กรุณากรอกเป็นตัวเลข");
                    kb.next();
                    wNum = true;
            }
                } while (wNum);
                    
                     
            switch(key){
                case 0 :{
                    System.out.println("ต้องการออกจากโปรแกรมหรือไม่ (Y / N)");
                    String Out = kb.next();
                    if(Out.equals("Y") || Out.equals("y") || Out.equals("N") || Out.equals("n") ){
                    if (Out.equals("Y") || Out.equals("y")) {
                        System.exit(0);
                    }
                    }
                    else{
                        System.out.println("กรอกคำสั่งไม่ถูกต้อง กรุณาทำรายการใหม่อีกครั้ง");
                    }
                }break;
                case 1 :{
                    System.out.println("เลือกคำสั่งที่ 1) เพิ่มสินค้า");
                    loop = 0;
                    do {
                        try{
                            System.out.print  ("จำนวนชนิดสินค้าที่ต้องการเพิ่ม : ");    
                            loop = kb.nextInt();
                            wNum = false;
                           }
                        catch(Exception e){
                            System.out.println("กรุณากรอกเป็นตัวเลข");
                            kb.next();
                            wNum = true;
                           }
                        } while (wNum);
                    for (int i = 0; i < loop; i++) {
                        System.out.println("====> ชิ้นที่ " + (i+1));
                        String name= "" ; int amount = 0; int priceper = 0;
                        System.out.print("ชื่อสินค้า : "); name = kb.next();
                        //amount check int
                        do {
                        try{
                            System.out.print  ("จำนวนสินค้า : ");    
                            amount = kb.nextInt();
                            wNum = false;
                           }
                        catch(Exception e){
                            System.out.println("กรุณากรอกเป็นตัวเลข");
                            kb.next();
                            wNum = true;
                           }
                        } while (wNum);
                        //priceper check int
                        do {
                        try{
                            System.out.print  ("ราคาต่อชิ้น : ");    
                            priceper = kb.nextInt();
                            wNum = false;
                           }
                        catch(Exception e){
                            System.out.println("กรุณากรอกเป็นตัวเลข");
                            kb.next();
                            wNum = true;
                           }
                        } while (wNum);
                        MC.addGoods(name, amount, priceper);
                    }
                }break;
                case 2 :{
                    System.out.println("เลือกคำสั่งที่ 2) ลบสินค้า");
                    System.out.println(MC.listGoods());
                    int id = 0;
                    do {
                        try{
                            System.out.print("เลือกรหัสสินค้าที่ต้องการลบ : "); 
                            id = kb.nextInt();
                            System.out.println("ท่านต้องการลบสินค้านี้ใช่หรือไม่");
                            System.out.println(MC.checkID(id));
                            System.out.println("(Y / N) : ");
                            String Out = kb.next();
                            if(Out.equals("Y") || Out.equals("y") || Out.equals("N") || Out.equals("n") ){
                                if (Out.equals("Y") || Out.equals("y")) {
                                    MC.delGoods(id);
                                }
                                else{System.out.println("ยกเลิกการลบสินค้า");}
                            }
                            else{
                                System.out.println("กรอกคำสั่งไม่ถูกต้อง กรุณาทำรายการใหม่อีกครั้ง");
                            }
                            wNum = false;
                           }
                        catch(Exception e){
                            System.out.println("กรุณากรอกเป็นตัวเลข");
                            kb.next();
                            wNum = true;
                           }
                        } while (wNum);
                    
                }break;
                case 3 :{
                    System.out.println("เลือกคำสั่งที่ 3) แสดงรายการสินค้า");
                    System.out.println(MC.listGoods());
                }break;
                case 4 :{
                    System.out.println("เลือกคำสั่งที่ 4) เพิ่ม/ลด จำนวนสินค้า");
                     System.out.println(MC.listGoods());
                    int id = 0; int amount = 0;
                    
                            System.out.println("ต้องการเพิ่มหรือลด [ เพิ่ม : U ],[ ลด : D ]");
                            String Out = kb.next();
                            if(Out.equals("U") || Out.equals("u") || Out.equals("D") || Out.equals("d") ){
                                if (Out.equals("U") || Out.equals("u")) {
                                   do{
                                    try{
                                    System.out.print("เลือกรหัสสินค้าที่ต้องการเพิ่ม : "); 
                                    id = kb.nextInt();
                                     }
                                        catch(Exception e){
                                        System.out.println("กรุณากรอกเป็นตัวเลข");
                                         kb.next();
                                        wNum = true;
                                     }
                                   }while(wNum);
                                   do{
                                    try{
                                    System.out.print("จำนวนสินค้าที่ต้องการเพิ่ม : ");
                                    amount = kb.nextInt();
                                    }
                                        catch(Exception e){
                                        System.out.println("กรุณากรอกเป็นตัวเลข");
                                         kb.next();
                                        wNum = true;
                                     }
                                   }while(wNum);
                                    if (amount <0) {
                                        amount = amount * (-1);
                                    }
                                    MC.Stockconfig(id, amount);
                                }
                                else{
                                     do{
                                    try{
                                    System.out.print("เลือกรหัสสินค้าที่ต้องการลด : "); 
                                    id = kb.nextInt();
                                    }
                                        catch(Exception e){
                                        System.out.println("กรุณากรอกเป็นตัวเลข");
                                         kb.next();
                                        wNum = true;
                                        
                                     }
                                   }while(wNum);
                                     do{
                                    try{
                                    System.out.print("จำนวนสินค้าที่ต้องการลด : ");
                                    amount = kb.nextInt() * (-1) ;
                                    }
                                        catch(Exception e){
                                        System.out.println("กรุณากรอกเป็นตัวเลข");
                                         kb.next();
                                        wNum = true;
                                     }
                                   }while(wNum);
                                    if (amount >0) {
                                        amount = amount * (-1);
                                    }
                                    MC.Stockconfig(id, amount);
                                }
                            }
                            else{
                                System.out.println("กรอกคำสั่งไม่ถูกต้อง กรุณาทำรายการใหม่อีกครั้ง");
                            }
                            wNum = false;
                }break;
                case 5 :{
                    System.out.println("เลือกคำสั่งที่ 5) ปรับราคาสินค้า");
                     System.out.println(MC.listGoods());
                    int id = 0; int price = 0;
                    do {
                        try{
                            System.out.print("เลือกรหัสสินค้าที่ต้องการปรับราคา : "); 
                            id = kb.nextInt();
                            System.out.println("ท่านต้องการปรับราคาสินค้านี้ใช่หรือไม่");
                            System.out.println(MC.checkID(id));
                            System.out.println("(Y / N) : ");
                            String Out = kb.next();
                            if(Out.equals("Y") || Out.equals("y") || Out.equals("N") || Out.equals("n") ){
                                if (Out.equals("Y") || Out.equals("y")) {
                                    System.out.print("ราคาสินค้าที่ต้องการปรับ : ");
                                    price = kb.nextInt();
                                    if (price <0) {
                                        price= price * (-1);
                                    }
                                    MC.Changeprice(id, price);
                                }
                                else{System.out.println("ยกเลิกการปรับราคาสินค้า");}
                                }
                            else{
                                System.out.println("กรอกคำสั่งไม่ถูกต้อง กรุณาทำรายการใหม่อีกครั้ง");
                                }
                            wNum = false;
                           }
                        catch(Exception e){
                            System.out.println("กรุณากรอกเป็นตัวเลข");
                            kb.next();
                            wNum = true;
                           }
                        } while (wNum);
                    
                }break;
                case 6 :{
                    System.out.println("เลือกคำสั่งที่ 6) ระบบขายสินค้า");
                    key = -1;
                    do{
                        System.out.println(MC.Menu1());
                         do {
                            try{
                                System.out.print("เลือกคำสั่งที่ : ");    
                                key = kb.nextInt();
                                wNum = false;
                                }
                            catch(Exception e){
                                System.out.println("กรุณากรอกเป็นตัวเลข");
                                kb.next();
                                wNum = true;
                                }   
                            } while (wNum);
                         switch(key){
                             case 1 : {
                                 System.out.println("เลือกคำสั่งที่ 1 )  เพิ่มสินค้าใส่ตระกร้า");
                                 System.out.println(MC.listGoods());
                                 boolean []c = new boolean [2]; int l=0;
                                do {    
                                    try{   
                                       System.out.print("จำนวนรายการที่ต้องการเพิ่ม : ");
                                       l = kb.nextInt();
                                       wNum = false;
                                       }
                                    catch(Exception e){
                                       System.out.println("กรุณากรอกเป็นตัวเลข");
                                       kb.next();
                                       wNum = true;
                                       }
                                    }while(wNum);
                                 for (int i = 1; i < l+1; i++) {
                                     System.out.println("=====> รายการที่ " + i);
                                     int a = 0 , b = 0; 
                                     do {    
                                        try{   
                                            System.out.print("รหัสสินค้า : ");
                                             a = kb.nextInt();}
                                            catch(Exception e){
                                                System.out.println("กรุณากรอกเป็นตัวเลข");
                                                kb.next();
                                                wNum = true;
                                            }
                                            }while(wNum);
                                     do {    
                                        try{  
                                            System.out.print("จำนวนที่ต้องการซื้อ : ");
                                             b = kb.nextInt();}
                                             catch(Exception e){
                                                
                                           System.out.println("กรุณากรอกเป็นตัวเลข");
                                           kb.next();
                                           wNum = true;
                                             }
                                           }while(wNum);
                                        
                                               c = MC.Cart(0, a, b);
                                            if ((c[0] == false && c[1] == false) || (c[0] == false && c[1] == true)) {
                                                System.out.println("ไม่มีสินค้าชิ้นนี้");
                                                i--;
                                            }
                                            else if (c[0] == true && c[1] == false) {
                                                System.out.println("สินค้ามีไม่เพียงพอ");
                                                i--;
                                            }
                                            else if (c[0] == true && c[1] == true) {
                                                System.out.println("ทำการเพิ่มสินค้าเรียบร้อย");
                                            }
                                            
                                           }
                                       
                                        
                                 }break;
                             case 2 : {
                                 System.out.println("เลือกคำสั่งที่ 1 )  ลดสินค้าในตระกร้า");
                                 System.out.println(MC.Reciept());
                                 boolean []c = new boolean [2]; int l=0;
                                do {    
                                    try{   
                                       System.out.print("จำนวนรายการที่ต้องการลด : ");
                                       l = kb.nextInt();
                                       wNum = false;
                                       }
                                    catch(Exception e){
                                       System.out.println("กรุณากรอกเป็นตัวเลข");
                                       kb.next();
                                       wNum = true;
                                       }
                                    }while(wNum);
//                                 
                                 for (int i = 1; i < l+1; i++) {
                                     System.out.println("=====> รายการที่ " + i);
                                     int a = 0 , b = 0; 
                                     do {    
                                        try{   
                                            System.out.print("รหัสสินค้า : ");
                                             a = kb.nextInt();}
                                            catch(Exception e){
                                                
                                           System.out.println("กรุณากรอกเป็นตัวเลข");
                                           kb.next();
                                           wNum = true;
                                           }
                                     }while(wNum);
                                     do {    
                                        try{  
                                            System.out.print("จำนวนที่ต้องการลด : ");
                                             b = kb.nextInt();}
                                             catch(Exception e){
                                               
                                           System.out.println("กรุณากรอกเป็นตัวเลข");
                                           kb.next();
                                           wNum = true;
                                           }
                                     }while(wNum);
                                               c = MC.Cart(1, a, b);
                                            if ((c[0] == false && c[1] == false) || (c[0] == false && c[1] == true) || (c[0] == true && c[1] == false)) {
                                                System.out.println("ไม่มีสินค้าชิ้นนี้ในตระกร้า");
                                                i--;
                                            }
                                            else if (c[0] == true && c[1] == true) {
                                                System.out.println("ทำการลดจำนวนสินค้าเรียบร้อย");
                                            }
                                           }

                                
                             }break;
                             case 3 : {
                                 System.out.println(MC.Reciept ());
                                 int r = 0;
                                 do {    
                                    try{   
                                       System.out.print("รับเงินมา : ");
                                       r = kb.nextInt();
                                       wNum = false;
                                       }
                                    catch(Exception e){
                                       System.out.println("กรุณากรอกเป็นตัวเลข");
                                       kb.next();
                                       wNum = true;
                                       }
                                    }while(wNum);
                                 System.out.println(MC.calCharge(r));                                 
                             }break;
                             default :
                         }
                         if (key > 4) {
                             System.out.println("ไม่มีคำสั่งนี้ กรุณาทำรายการใหม่");
                             key = -1;
                        }
                    }while(key != 4);
                }break;
                
                default :}
            } 
        
        
       
    }
}
