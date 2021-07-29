import java.util.Scanner;
import java.util.Random;
public class Main {
  public static int[][] senkan = new int[7][7];

  //Mainの処理
    public static void main(String[] args) {

        System.out.println("*******************");
        System.out.println("    戦艦ゲーム   ");
        System.out.println("*******************");
        int a = 1;

        Ship ship1 = new Ship();
        Ship ship2 = new Ship();
        Ship ship3 = new Ship();

        ship1.ship = 1;
        ship2.ship = 2;
        ship3.ship = 3;


        random(ship1);
        random(ship2);
        random(ship3);

        Scanner Scanner = new Scanner(System.in);

        while(!(ship1.count == 0 && ship2.count == 0 && ship3.count == 0)){

          System.out.print("船1:");
          alive(ship1);
          System.out.print("船2:");
          alive(ship2);
          System.out.print("船3:");
          alive(ship3);

          System.out.println("-----[ターン" + a + "]-----");

        //検査用(敵のいる場所)
        /*for(int i = 1;i < senkan.length-1;i++){
          for(int j = 1;j < senkan.length-1;j++){
            System.out.print(senkan[i][j] + " ");
          }
          System.out.println();
        }
        */
        

        //検査用(残り機数)
        //System.out.println(ship1.count + " "  + ship2.count + " " +  ship3.count);

        System.out.println("爆弾のX座標を入力してください(1-5)");
        int x = Scanner.nextInt();

        System.out.println("爆弾のY座標を入力してください(1-5)");
        int y = Scanner.nextInt();

        System.out.println("-------------------");

        if(x >= 1 && x <= 5 && y >= 1 && y <= 5 ){
          Bomb(x,y,ship1,ship2,ship3);
        }
        a++;
      }
      System.out.println("クリアおめでとうございます！★");
      System.out.println("-------------------");
      Scanner.close();
  }
  
  //船を配置
      public static void random(Ship sp) {
        Random rn = new Random();
        while(true){
        int X  = rn.nextInt(5) + 1;
        int Y = rn.nextInt(5) + 1;
        
        if(senkan[Y][X] == 0){
          senkan[Y][X] = sp.ship;
          senkan[sp.Y][sp.X] = 0;
          sp.X = X;
          sp.Y = Y;

          break;
        }
      }
        
      }
      
      //戦艦当たり判定エリア
      public static void Bomb(int x,int y,Ship sp1,Ship sp2,Ship sp3){
        //戦艦1判定
        if(senkan[y][x] == 1){
          sp1.count--;
          System.out.println("戦艦1に当たった！");
          random(sp1);
        }else if(senkan[y][x + 1] == 1){
          System.out.println("波高し！");
        }else if(senkan[y + 1][x] == 1){
          System.out.println("波高し！");
        }else if(senkan[y][x - 1] == 1){
          System.out.println("波高し！");
        }else if(senkan[y - 1][x] == 1){
          System.out.println("波高し！");
        }else{
          System.out.println("ハズレ！ドンマイ！");
        }

        //戦艦2判定
        if(senkan[y][x] == 2){
          sp2.count--;
          System.out.println("戦艦2に当たった！");
          random(sp2);
        }else if(senkan[y][x + 1] == 2){
          System.out.println("波高し！");
        }else if(senkan[y + 1][x] == 2){
          System.out.println("波高し！");
        }else if(senkan[y][x - 1] == 2){
          System.out.println("波高し！");
        }else if(senkan[y - 1][x] == 2){
          System.out.println("波高し！");
        }else{
          System.out.println("ハズレ！ドンマイ！");
        }

        //戦艦3判定
        if(senkan[y][x] == 3){
          System.out.println("戦艦3に当たった！");
          random(sp3);
          sp3.count--;
        }else if(senkan[y][x + 1] == 3){
          System.out.println("波高し！");
        }else if(senkan[y + 1][x] == 3){
          System.out.println("波高し！");
        }else if(senkan[y][x - 1] == 3){
          System.out.println("波高し！");
        }else if(senkan[y - 1][x] == 3){
          System.out.println("波高し！");
        }else{
          System.out.println("ハズレ！ドンマイ！");
        }

        System.out.println("-------------------");

      }

        public static void alive(Ship sp){
          if(sp.count == 0){
            sp.flag = false;
          }
          if(sp.flag){
            System.out.println("生存している！");
          }else{
            System.out.println("撃沈している！");
          }
        }
}