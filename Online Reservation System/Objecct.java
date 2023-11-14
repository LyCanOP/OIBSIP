package OnlineReservationSystem;

import java.io.Serializable;

public class Objecct implements Serializable {
    String finalName, finalSrcStation, finalDesStation, finalTime, finalPrnNo, finalPhoneNo, finalPrice;
    public Boolean isTicked = true;
    public void setValues(String Name,String SrcStation,String DesStation,String Time,String PrnNo,String PhoneNo, String Price){
        finalName = Name;
        finalSrcStation = SrcStation;
        finalDesStation = DesStation;
        finalTime = Time;
        finalPrnNo = PrnNo;
        finalPhoneNo = PhoneNo;
        finalPrice = Price;
    }
}
