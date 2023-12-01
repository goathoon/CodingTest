public class Airplane {
    public static void main(String [] args){
        Airplane a1 = new Airplane();
        Airplane a2 = new Airplane("blue");
        Airplane a3 = new Airplane("black");
        System.out.println("a1의 고유번호는 "+ a1.airplaneNumber + " a1의 고유 색깔은 " + a1.color);
        System.out.println("a2의 고유번호는 "+ a2.airplaneNumber + " a2의 고유 색깔은 " + a2.color);
        System.out.println("a3의 고유번호는 "+ a3.airplaneNumber + " a3의 고유 색깔은 " + a3.color);
    }
    static int serialNum;
    String color = "white";
    int airplaneNumber;
    static{
        serialNum = 0;
    }
    {
        serialNum++;
        this.airplaneNumber = serialNum;
    }
    Airplane(String color){
        this.color = color;
    }
    Airplane(){
    }
}
