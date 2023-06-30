/**
 * @author Apinun Umbao
 * ID 6303051623195
 */
public class MarketClass {
        
        private  String [][] Stock ;
        private int Goods = 0 , sum = 0 ,Recieptnum = 1;
        private int [] CalG;
        private final int vat7 = 7;

    
    public String Menu0(){    
          String m0 = 
                      "         (กดหมายเลขคำสั่งเพื่อทำรายการ)\n"+
                      "    1 )  เพิ่มสินค้า\n"+
                      "    2 )  ลบสินค้า\n"+
                      "    3 )  แสดงรายการสินค้า\n"+
                      "    4 )  เพิ่ม/ลด จำนวนสินค้า\n"+
                      "    5 )  ปรับราคาสินค้า\n"+
                      "    6 )  ระบบขายสินค้า\n"+
                      "    0 )  ออกจากโปรแกรม\n";
    
     return m0;
    }
    public String Menu1(){
        String m1 = 
                      "         (กดหมายเลขคำสั่งเพื่อทำรายการ)\n"+
                      "    1 )  เพิ่มสินค้าใส่ตระกร้า\n"+
                      "    2 )  ลดสินค้าในตระกร้า\n"+
                      "    3 )  สรุปราคาและคิดเงิน\n"+
                      "    4 )  กลับสู่หน้าหลัก\n"
                     ;
        return m1;
    }

    public MarketClass(){
         this.Stock = new String[1][3];
         this.CalG = new int [this.Stock.length]; 
    }
    
    public void addGoods (String name , int amount , int priceper){
        if ((Goods+1)>Stock.length) {
            addGoods();
        }
        this.Stock[Goods][0] = name;
        this.Stock[Goods][1] = Integer.toString(amount);
        this.Stock[Goods][2] = Integer.toString(priceper);
        Goods++;
    }
    private void addGoods(){
        String [][] cStock = new String [this.Stock.length + 1][this.Stock[0].length];
        int []cCalG = new int [cStock.length];
        for (int i = 0; i < this.Stock.length; i++) {
            cCalG[i] = this.CalG[i];
            for (int j = 0; j <3; j++) {
                cStock[i][j]=this.Stock[i][j];
            }
            

        }
        this.Stock = new String [cStock.length][cStock[0].length];
        this.CalG = new int [cCalG.length];
        for (int i = 0; i < this.Stock.length-1; i++) {
            this.CalG[i] = cCalG[i];
            for (int j = 0; j <3; j++) {
                this.Stock[i][j]=cStock[i][j];
            }

        }
    }
    
    public void delGoods(int id){
        id = id - 1 ;
        String [][] cStock = new String [this.Stock.length - 1][this.Stock[0].length];
        for (int i = 0; i < id-1 ; i++) {
            for (int j = 0; j <3; j++) {
                 cStock[i][j]=this.Stock[i][j];
            }

        }
        for (int i = id-1; i < cStock.length ; i++) {
            for (int j = 0; j <3; j++) {
                cStock[i][j]=this.Stock[i+1][j];
            }

        }
        this.Stock = new String [cStock.length][cStock[0].length];
        for (int i = 0; i < this.Stock.length; i++) {
            for (int j = 0; j <3; j++) {
               this.Stock[i][j]=cStock[i][j]; 
            }

        }
    }
    
    public String listGoods(){
        String s = "================สินค้าทั้งหมด================\n" ;
        for (int i = 0; i < this.Stock.length; i++) {
            s +=   "=========================================\n";
            s +=   " รหัสสินค้า        : " + (i+1)            + "\n";
            s +=   " ชื่อสินค้า         : " + this.Stock[i][0] + "\n";
            s +=   " จำนวนสินค้า      : " + String.format("%,.0f", Integer.parseInt(this.Stock[i][1])+0.0) + " ชิ้น\n";
            s +=   " ราคาขายสินค้า    : " + String.format("%,.0f", Integer.parseInt(this.Stock[i][2])+0.0) + " บาท\n";
        }
        s +=       "=========================================\n";
       
        return s;
    }
    
    public void Stockconfig (int id , int amount){ 
        id = id - 1;
        if((id+1) <= this.Stock.length){
        this.Stock[id][1] = Integer.toString((Integer.parseInt(this.Stock[id][1])) + amount);
            if ((Integer.parseInt(this.Stock[id][1])) < 0) {
                this.Stock[id][1] = Integer.toString(0);
            }
        }
    }
    
    public void Changeprice (int id , int price){
       if(price>=0){
        this.Stock[id-1][2] = Integer.toString(price); 
       }
    }
    
    public boolean [] Cart(int Status , int id , int piece ){
        
        boolean [] s = new boolean [2];
        
            if((id-1) > this.Stock.length-1){
                s[0]= s[1] = false;
                return s;
            }
            else {
                s[0] = true;
            }
        
        
        switch(Status){
       /*เพิ่มสินค้า*/     case 0 :{
                             if(piece <= Integer.parseInt(this.Stock[(id-1)][1])){
                                 CalG((id-1),piece);
                                 s[1] = true;
                            }
                             
                    break;}
            
        /*ลบสินค้า*/    case 1 :{
                                CalG((id-1),(piece * (-1)));
                                s[1] = true;
                            
                    
                    break;} 
    
    
}
    return s;}
    private void CalG (int id , int amount){
        if(id < this.CalG.length)
        {CalG[id] += amount;
        if(CalG[id] < 0) CalG[id] = 0;}
    }
    
    public String Reciept (){
        java.util.Date date = new java.util.Date();   
        int count=0;
        String s = "เลขที่ใบเสร็จ : "+ Recieptnum +"\n"+
                   "===========สรุปคำสั่งซื้อ===========\n" +
                   "\t" + date + "\n";
        
        for (int i = 0 ;( i < this.CalG.length ); i++) {
//            if(this.CalG[i] != 0)
            {s += "รหัสสินค้า : "+ (i+1) +"\tสินค้า : " + this.Stock[i][0] + "\nจำนวน : " + CalG[i] + " ชิ้น " +
                 "\t\tราคา" + String.format("%,.0f", Integer.parseInt(this.Stock[i][2])*CalG[i]+0.0) + "บาท\n"+
                 "------------------------------------------------------\n";
            sum += Integer.parseInt(this.Stock[i][2])*CalG[i];
            count += CalG[i] ;
            }
            }
        s += "\nสรุปสินค้าจำนวน : " +  count + " ชิ้น " + "\t\tราคา : " + String.format("%,.0f", sum+0.0) + " บาท";
        
        return s;
    }
    
    public String calCharge (int in){
        Recieptnum++;
        int sumvat = sum + (sum * (vat7 / 100)) ;
        int give = in - sumvat;
        String r;
               r = "-----------------คิดราคา-----------------\n"+
                   "ราคาก่อนคิดภาษี : " + String.format("%,.0f", sum+0.0) + " บาท \n"+
                   "ภาษีมูลค่าเพิ่ม : " + vat7 + " % \n"+
                   "รวมเป็นเงิน : " + String.format("%,.0f", sumvat+0.0) + " บาท \n"+
                   "รับเงินมา : " + String.format("%,.0f", in + 0.0) + " บาท " +
                   "ทอนเงิน : " + String.format("%,.0f", give + 0.0) + " บาท ";
                sum = 0 ; // Clear
           if(give < 0){
            r = "\tยกเลิกการขาย\n\tเงินไม่เพียงพอ\n\tกรุณาทำรายการใหม่";
        }
        return r;
    }
    
    public String checkID (int id){
        String s = "======================================\n";
               s+= " ชื่อสินค้า         : " + this.Stock[id-1][0] + "\n";
    return     s + "======================================";
    }
    
}
