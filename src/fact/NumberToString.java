/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

/**
 *
 * @author suraj
 */
class NumberToString
{

    public enum hundreds {One_Hundred, Two_Hundred, Three_Hundred, Four_Hundred, Five_Hundred, Six_Hundred, Seven_Hundred, Eight_Hundred, Nine_Hundred}
    public enum tens {Twenty, Thirty, Forty, Fifty, Sixty, Seventy, Eighty, Ninety}
    public enum ones {One, Two, Three, Four, Five, Six, Seven, Eight, Nine}
    public enum denom {Thousand, Lakhs, Crores}
    public enum splNums { Ten, Eleven, Twelve, Thirteen, Fourteen, Fifteen, Sixteen, Seventeen, Eighteen, Nineteen}
    public static String text = "";
static long numbertoconvert=0;

    public static String NumberConvert(long number) {
        numbertoconvert=number;
        convert();
        return text.replace("_", " ");
    }

    public static void main(String[] args)
    {
        System.out.println("Enter Number to convert into words");

    }
    public static void convert()
    {
        long num = numbertoconvert;
        int rem = 0;
        int i = 0;
        while(num > 0)
        {
            if(i == 0){
                rem = (int) (num % 1000);
                printText(rem);
                num = num / 1000;
                i++;
            }
            else if(num > 0)
            {
                rem = (int) (num % 100);
                if(rem > 0)
                    text = denom.values()[i - 1]+ " " + text;
                printText(rem);
                num = num / 100;
                i++;
            }
        }
        if(i > 0)
            System.out.println(text);
        else
            System.out.println("Zero");
    }

    public static void printText(int num)
    {
        if(!(num > 9 && num < 19))
        {
            if(num % 10 > 0)
                getOnes(num % 10);

            num = num / 10;
            if(num % 10 > 0)
                getTens(num % 10);

            num = num / 10;
            if(num > 0)
                getHundreds(num);
        }
        else
        {
            getSplNums(num % 10);
        }
    }

    public static void getSplNums(int num)
    {
        System.out.println("spl "+num+" "+splNums.values()[num - 1]);
        text = splNums.values()[num]+ " " + text;
    }

    public static void getHundreds(int num)
    {
        System.out.println("hundred "+num+" "+hundreds.values()[num - 1]);
        text = hundreds.values()[num - 1]+ " " + text+" ";
    }

    public static void getTens(int num)
    {
        System.out.println("tens "+num+" "+tens.values()[num - 1]);
        text = tens.values()[num - 2]+ " " + text;
    }

    public static void getOnes(int num)
    {
        System.out.println("ones "+num+" "+ones.values()[num - 1]);
        text = ones.values()[num - 1]+ " " + text;
    }
}
