import org.json.JSONObject;

import java.util.Iterator;

public class JsonCompare {

    public boolean jsonComparing(String actualResult, String expectedResult){
        boolean status = false;
        String [] actualValue;
        String [] expectedValue;
        String[] actualLine = actualResult.split(",");
        String[] expectedLine = expectedResult.split(",");
        for(int i = 0 ; i < expectedResult.length() ; i++ ){
            actualValue = actualLine[i].split(":");
            expectedValue = expectedLine[i].split(":");
            if(actualValue[0].equals(expectedValue[0])){
                if( actualValue[1].equals(expectedValue[1]) || expectedValue[1].equals("Ignore") ){
                    status = true;
                }else {
                    System.out.println("ERROR EN EL RESULTADO, SE ESPERA "+ expectedValue[0]+" : "+expectedValue[1]);
                    System.out.println("SE TIENE "+ actualValue[0]+" : "+actualValue[1]);
                    return false;
                }
            }else{
                System.out.println("ERROR EN EL RESULTADO, SE ESPERA "+ expectedValue[0] );
                System.out.println("SE TIENE "+ actualValue[0] );
                return false;
            }
        }
        return status;
    }

    //Teacher solution
    public boolean areEqualJson(String expectedResult, String actualResult ){
        boolean areEqual = true;
        JSONObject expecrtedResJSON = new JSONObject(expectedResult);
        JSONObject actualResJSON = new JSONObject(actualResult);

        Iterator<?> propetiesList = actualResJSON.keys();

        while (propetiesList.hasNext()){
            String keys = (String) propetiesList.next();
            String expValue = (String) expecrtedResJSON.get(keys);
            String actValue = (String) actualResJSON.get(keys);

            if (expValue.equals("IGNORE")){
                System.out.println("Propiedad ["+keys +"] es ignorado para la verificacion" );
            }else if (!expValue.equals(actValue)){
                areEqual = false;
                System.out.println("ERROR  al comparar el Key ["+keys+"] exp: ["+expValue+"] act: ["+actValue+"]");
            }else{
                System.out.println("la porpiedad ["+keys+"] no existe en el actual result");
            }
        }
        return areEqual;
    }
}
