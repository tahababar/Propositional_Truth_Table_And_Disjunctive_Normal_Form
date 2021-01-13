import java.util.*;

public class Proposition{

    private static boolean resultA;
    private static boolean resultB;
    private static boolean resultC;
    private static boolean resultD;
    private static boolean resultE;
    private static String[] arr = new String[16];
    private static int count = 0;

    public static void main(String[] args)
    {   
        String DNFResult = "";
        
        System.out.println("a b c d | e");
        System.out.println("------------");
        displayResult(false,false,false,false);
        displayResult(false,false,false,true);
        displayResult(false,false,true,false);
        displayResult(false,false,true,true);
        displayResult(false,true,false,false);
        displayResult(false,true,false,true);
        displayResult(false,true,true,false);
        displayResult(false,true,true,true);
        displayResult(true,false,false,false);
        displayResult(true,false,false,true);
        displayResult(true,false,true,false);
        displayResult(true,false,true,true);
        displayResult(true,true,false,false);
        displayResult(true,true,false,true);
        displayResult(true,true,true,false);
        displayResult(true,true,true,true);

        for(int i = 0; i < count; i++)
        { 
            DNFResult = DNFResult + arr[i] + " || " ;
        }
        
        if (!DNFResult.equals("")){
            DNFResult = DNFResult.substring(0, DNFResult.length()-4);
            System.out.println(DNFResult);
        }
        else
        {
            System.out.println("false");
        }
    }

    public static boolean myExpression(boolean a, boolean b, boolean c, boolean d)
    {
        return !(a && b && !c) && (b && d); //add expression here
    }

    public static String convertBoolToString(boolean x)
    {
        if (x == true)
        { return "T";
        }
        else
        { return "F";
        }  
    }

    public static String DNF(String x)
    {   
        String forA;
        String forB;   
        String forC;
        String forD;
        
        if (x.equals("T"))
        {
            if (resultA == true)
            { forA = "a";
            }
            else
            { forA = "!a";
            }
            if (resultB == true)
            { forB = "b";
            }
            else
            { forB = "!b";
            }
            if (resultC == true)
            { forC = "c";
            }
            else
            { forC = "!c";
            }
            if (resultD == true)
            { forD = "d";
            }
            else
            { forD = "!d";
            }
            arr[count] = ("(" + forA + " && " + forB + " && " + forC + " && " + forD + ")");
            count = count + 1;
        }
        
        return "none"; 
    }

    public static boolean displayResult(boolean a, boolean b, boolean c, boolean d)
    {   
        String finalResultA = "none";
        String finalResultB = "none";
        String finalResultC = "none";
        String finalResultD = "none";
        String finalResultE = "none";
        
        resultA = a; resultB = b; resultC = c; resultD = d;
        resultE = myExpression(resultA, resultB, resultC, resultD);
        
        finalResultA = convertBoolToString(resultA);
        finalResultB = convertBoolToString(resultB);
        finalResultC = convertBoolToString(resultC);
        finalResultD = convertBoolToString(resultD);
        finalResultE = convertBoolToString(resultE);
        
        DNF(finalResultE);
        
        System.out.println(finalResultA + " " + finalResultB + " " + finalResultC + " " + finalResultD + " " + "|" + " " + finalResultE);
        
        return true;
    }

}