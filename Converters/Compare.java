package Converters;

public class Compare {


     static boolean isalpha(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
            {
            return true;
            }
            return false;
        }   

        static boolean isdigit(char c)
        {
            if (c >= '0' && c <= '9')
            {
            return true;
            }
            return false;
        }

        static boolean isOperator(char c)
        {
            return (!isalpha(c) && !isdigit(c));
        }

}
