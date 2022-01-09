import java.util.Scanner;  // Import the Scanner class

class vend{
    public static void main(String[] args){
        display_items my = new display_items();
        my.display_items();
    }

}

class display_items{

    void display_items(){
        int choice;
        Scanner sc = new Scanner(System.in);
        add_items add = new add_items();
        calculations calc = new calculations();
        insufficient decline = new insufficient();
        transaction buy = new transaction();
        buy.get_calc(calc);
        decline.get_calc(calc);

        while(true) {
            System.out.println("\n\n-------Drink Vending Machine ------------");
            System.out.println("1. Pepsi");
            System.out.println("2. Dr. Pepper");
            System.out.println("3. Sunkist");
            System.out.println("4. Surge");
            System.out.println("5. insert money");
            System.out.println("6. withdraw money");
            System.out.println("7. check balance");
            System.out.println("8. restock");
            System.out.println("9. check inventory");
            System.out.println("10. Exit the program...\n");
            System.out.println("Choose one:");
            choice = sc.nextInt();

            switch(choice){
                case 1:

                    if(add.get_inventory()[0] == 0){
                        System.out.println("out of stock");
                        calc.withdraw();
                    }else{
                        add.get_inventory()[0] -= 1;
                    }
                    break;
                case 2:
                    System.out.println("soda");
                    break;
                case 3:
                    System.out.println("gum");
                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("insert money");
                    calc.comp_method();
                    break;
                case 6:
                    calc.withdraw();
                    break;
                case 7:
                    calc.total();
                    break;
                case 8:
                    add.add();
                    break;
                case 9:
                    add.available();
                    break;
                case 10:
                    return;
            }
        }
    }

}


class calculations{
    private double total=0;
    private int[] myNum = {0, 0, 0, 0};
    private double last;
    String[] denominations = {"Dollars", "quarters", "dimes", "nickels"};

    void comp_method(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        for (int i = 0; i < denominations .length; i++)
        {
            System.out.println("enter "+denominations[i]);
            int input = myObj.nextInt();
            myNum[i]=input;
            if (i==0)
            {
                total = total +(myNum[i]*1);
            } else if (i ==1){
                total = total +(myNum[i]*0.25);
            }else if (i ==2){
                total = total +(myNum[i]*0.10);
            }else if (i ==3){
                total = total +(myNum[i]*0.05);
            }
        }

        for (int i = 0; i < denominations .length; i++)
        {
            System.out.println(denominations[i]+":  "+myNum[i]);
        }

    }
    void total(){
        last = total;
        System.out.println("total: "+last);

    }

    void withdraw(){
        for (int i = 0; i < denominations .length; i++)
        {
            System.out.println("Returning: "+denominations[i]+": "+myNum[i]);
            myNum[i]=0;
        }
        for (int i = 0; i < denominations .length; i++)
        {
            myNum[i]=0;
        }
        total =0;
        System.out.println("Balance: "+total);
    }

}


class add_items{
    String[] items = {"Pepsi \t", "Dr. Pepper", "Sunkist\t", "Surge\t"};
    private int[] inventory = {0, 0, 0, 0};
    private double[] price = {1.20, .50, .75, 1.50};
    Scanner stock = new Scanner(System.in);  // Create a Scanner object


    void add(){
        for (int i = 0; i < items .length; i++)
        {
            System.out.println("enter "+items[i]);
            int input = stock.nextInt();
            inventory[i] +=input;
        }
    }

    public int [] get_inventory(){
        return this.inventory;
    }

    void available()
    {
        for (int i = 0; i < items .length; i++)
        {
            System.out.println(items[i]+"\t quanity: \t"+inventory[i]+"\tprice: \t"+price[i]);
        }
    }
}

class insufficient{
    calculations calc;

    void get_calc(calculations calc){
        this.calc = calc;
    }
    void insufficient()
    {
        calc.withdraw();

    }
}

class transaction{
    calculations calc;

    void get_calc(calculations calc){
        this.calc = calc;
    }

    void transaction(){

    }
}