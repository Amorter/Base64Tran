package cool.limit;
public class Tran {
    public static final char[] hisLetter = {'A','B','C','D','E', 'F','G','H','I','J','K','L', 'M', 'N','O','P','Q','R','S', 'T','U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9',
            '+','/'};
    public static String tran(String input) {
        String result = "";
        char[] inputArray = input.toCharArray();
        int reminder = inputArray.length % 3;
        int num = 0;
        while (num <= inputArray.length -3){
            result = result + String.valueOf(tranSide(new char[] {inputArray[num],inputArray[num+1],inputArray[num+2]}));
            num += 3;
        }
        if (reminder == 1) {
            result = result + String.valueOf(tranOther(new char[] {inputArray[num]}));
        }else if (reminder == 2) {
            result = result + String.valueOf(tranOther(new char[] {inputArray[num],inputArray[num + 1]}));
        }
        return result;
    }

    //输入原始数据，返回进位和原始索引
    private static int[] get64bit(int input){
        return new int[] {input / 64,input % 64};
    }

    private static char[] tranSide(char[] inputArray){
        int a_1 = inputArray[0] * 16;
        int a_2 = inputArray[1] * 4;
        int a_3 = inputArray[2] * 1;

        int[] a_3_rate = get64bit(a_3);
        int[] a_2_rate = get64bit(a_2);
        int[] a_1_rate = get64bit(a_1);

        return new char[] {hisLetter[a_1_rate[0]],hisLetter[a_1_rate[1]+a_2_rate[0]],hisLetter[a_2_rate[1]+a_3_rate[0]],hisLetter[a_3_rate[1]]};
    }
    private static char[] tranOther(char[] inputArray){
        if(inputArray.length == 1){
            int a_1 = inputArray[0] * 16;
            int[] a_1_rate = get64bit(a_1);
            return new char[] {hisLetter[a_1_rate[0]],hisLetter[a_1_rate[1]],'=','='};
        }else if (inputArray.length == 2) {
            int a_1 = inputArray[0] * 16;
            int a_2 = inputArray[1] * 4;
            int[] a_1_rate = get64bit(a_1);
            int[] a_2_rate = get64bit(a_2);
            return new char[] {hisLetter[a_1_rate[0]], hisLetter[a_1_rate[1] + a_2_rate[0]], hisLetter[a_2_rate[1]],'='};
        }else {
            return new char[] {'e'};
        }
    }
}