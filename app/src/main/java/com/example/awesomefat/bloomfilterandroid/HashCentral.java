package com.example.awesomefat.bloomfilterandroid;

/**
 * Created by awesomefat on 12/2/15.
 */
public class HashCentral
{
    static String rot13(String s)
    {
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = lowerCase.toUpperCase();
        String answer = "";
        for(int i = 0; i < s.length(); i++)
        {
            if(lowerCase.indexOf(s.charAt(i)) != -1)
            {
                //it exists in the lower case alphabet
                answer += lowerCase.charAt((lowerCase.indexOf(s.charAt(i)) + 13) % 26);
            }
            else if(upperCase.indexOf(s.charAt(i)) != -1)
            {
                //it exists in the upper case alphabet
                answer += upperCase.charAt((upperCase.indexOf(s.charAt(i)) + 13) % 26);
            }
            else
            {
                answer += s.charAt(i);
            }
        }
        return answer;
    }

    static int rot13Hash(String s, int numBits)
    {
        String answer = HashCentral.rot13(s);
        byte[] theBytes = answer.getBytes();
        int valueToReturn = theBytes[theBytes.length/2] >> numBits;
        return valueToReturn;
    }

    static int stringHash(String s, int maxVal)
    {
        int sum = 0;
        for(int i = 0; i < s.length(); i++)
        {
            sum += (int)s.charAt(i);
        }
        return sum % maxVal;
    }
}
