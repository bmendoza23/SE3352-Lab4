import java.util.ArrayList;

public class tempTransformer {
    public static void main(String[] args){
        double[] tempsC = {4.5, 12.7, 11, 18.9, 7.90, 5.3};      //Variable array to hold temperatures
        ArrayList<Double> tempsCList = new ArrayList<Double>();  //Variable ArrayList

        //Loading tempsC into tempsCList so we can use those temperature in an arraylist
        for(int i = 0; i < tempsC.length; i++)
        {
            tempsCList.add(tempsC[i]);
        }

        //Filter for max value

        double max = tempsC[0];         //Variable to hold max length, initialized as first element of tempsC array
        //Iterating over tempsC
        for (int i = 0; i<tempsC.length; i++)
        {   
            //Comparing next element of the array with the previous
            for (int j = i+1; j<tempsC.length; j++)
            {
                //If the next element is larger than max
                if (tempsC[j] > max)
                {
                    max = tempsC[j];    //Set the larger element as our new max
                }
            }
        }

        tempsCList.remove(max);                           //Remove the max from the list.
        ArrayList<Double> tempsCNoMax = tempsCList;       //New list made without max variable

        //Filter for min value

        double min = tempsC[0];         //Variable to hold min length, initialized as first value in tempsC

        //Iterating over tempsC
        for (int i = 0; i<tempsCNoMax.size(); i++)
        {
            tempsC[i] = min;            //Initializing max as first element of the array

            //Comparing next element of the array with the previous
            for (int j = i+1; j<tempsCNoMax.size(); j++)
            {
                //If the next element is less than the min
                if (tempsC[j] < min)
                {
                    min = tempsC[j];    //Set the smaller element as our new min
                    
                }
            }
        }
        tempsCNoMax.remove(min);                            //Remove the min value from the list.
        ArrayList<Double> tempsCNoMinMax = tempsCNoMax;     //New list made without max and min variable

        //Creating a new array to hold the filtered out values
        Double[] tempsCNoOutliers = new Double[tempsCNoMinMax.size()];  
         
        //Converts tempsCNoMinMax to an array, and fills tempsCNoOutliers with its values
        tempsCNoOutliers = tempsCNoMinMax.toArray(tempsCNoOutliers);

        //Variable to hold converted temperatures
        double[] tempsF = new double[tempsCNoOutliers.length]; 

        //Loops over length of tempsCNoOutliers
        for (int i=0; i<tempsCNoOutliers.length; i++)
        {
            tempsF[i] = ((tempsCNoOutliers[i] * 9/5) + 32); //Inserts converted temperature values
        }

        //Loops over length of tempsF
        for(int i=0; i<tempsF.length;i++)
        {
            System.out.println(tempsF[i]);  //Printing out the values of tempsF
        }

    }
}