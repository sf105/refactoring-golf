import bustapaga.buca01.BustaPagaTest01;
import bustapaga.buca02.BustaPagaTest02;
import bustapaga.buca03.BustaPagaTest03;
import bustapaga.buca04.BustaPagaTest04;
import bustapaga.buca05.BustaPagaTest05;
import bustapaga.buca06.BustaPagaTest06;
import bustapaga.buca07.BustaPagaTest07;
import bustapaga.buca08.BustaPagaTest08;
import bustapaga.buca09.BustaPagaTaxTest09;
import bustapaga.buca09.BustaPagaTest09;
import bustapaga.buca09.CalcolatoreScaglioneTasseTest;
import bustapaga.buca10.BustaPagaTaxTest10;
import bustapaga.buca10.BustaPagaTest10;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(int buca) {
        int count=0,count2=0,count3=0;
        Result result=null, result2=null,result3=null;
        switch (buca) {
            case 1 : result = JUnitCore.runClasses(BustaPagaTest01.class); break;
            case 2 : result = JUnitCore.runClasses(BustaPagaTest02.class); break;
            case 3 : result = JUnitCore.runClasses(BustaPagaTest03.class); break;
            case 4 : result = JUnitCore.runClasses(BustaPagaTest04.class); break;
            case 5 : result = JUnitCore.runClasses(BustaPagaTest05.class); break;
            case 6 : result = JUnitCore.runClasses(BustaPagaTest06.class); break;
            case 7 : result = JUnitCore.runClasses(BustaPagaTest07.class); break;
            case 8 : result = JUnitCore.runClasses(BustaPagaTest08.class); break;
            case 9 : result = JUnitCore.runClasses(BustaPagaTest09.class);
                     result2 = JUnitCore.runClasses(BustaPagaTaxTest09.class);
                     result3 = JUnitCore.runClasses(CalcolatoreScaglioneTasseTest.class);break;
            case 10 : result = JUnitCore.runClasses(BustaPagaTest10.class);
                     result2 = JUnitCore.runClasses(BustaPagaTaxTest10.class);break;
        }
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            count++;
        }


        System.out.println("\nBustaPagaTest"+buca+":");
        System.out.println(result.wasSuccessful() ? "OK" : "Test con errori: "+count);

        if (buca==9 || buca==10) {
            for (Failure failure : result2.getFailures()) {
                System.out.println(failure.toString());
                count2++;
            }
            System.out.println("\nBustaPagaTaxTest"+buca+":");
            System.out.println(result2.wasSuccessful() ? "OK" : "Test con errori: "+count2);
        }

    }
}
