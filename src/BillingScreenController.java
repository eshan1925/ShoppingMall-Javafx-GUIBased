import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class BillingScreenController {

    @FXML
    private RadioButton ABC;

    @FXML
    private TextField Discount_Amt;

    @FXML
    private RadioButton XYZ;

    @FXML
    private Button clear;

    @FXML
    private Button exit;

    @FXML
    private TextField finalPrice;

    @FXML
    private TextField finalbill;

    @FXML
    private Button netPrice;

    @FXML
    private RadioButton visa;

    @FXML
    void calculateNetPrice(ActionEvent event) {
        ToggleGroup member =new ToggleGroup();
        visa.setToggleGroup(member);
        XYZ.setToggleGroup(member);
        ABC.setToggleGroup(member);
        RadioButton rb =(RadioButton) member.getSelectedToggle();
        String membselected = rb.getText();
        String billofUser = finalbill.getText();
        int billing = Integer.parseInt(billofUser);
        int discountPercent=0;
        if (billing <= 0) {
            finalbill.setText("");
            JOptionPane.showMessageDialog(null, "Bill has invalid value", "Warning", 1);
        } else if(membselected.equals("VISA")) {
            if(billing<5000){
                discountPercent = 10;
            }else if(billing>=5000){
                discountPercent = 20;
            }
            int fullbill = billing - (discountPercent*billing)/100;
            Discount_Amt.setText(String.valueOf((discountPercent*billing)/100));
            finalPrice.setText(String.valueOf(fullbill));
        } else if(membselected.equals("XYZ")){
            if(billing<10000){
                discountPercent = 15;
            }else if(billing>=10000){
                discountPercent = 25;
            }
            int fullbill = billing - (discountPercent*billing)/100;
            Discount_Amt.setText(String.valueOf((discountPercent*billing)/100));
            finalPrice.setText(String.valueOf(fullbill));
        } else if(membselected.equals("ABC")){
            if(billing<8000){
                discountPercent = 12;
            }else if(billing>=8000){
                discountPercent = 15;
            }
            int fullbill = billing - (discountPercent*billing)/100;
            Discount_Amt.setText(String.valueOf((discountPercent*billing)/100));
            finalPrice.setText(String.valueOf(fullbill));
        } 
    }

    @FXML
    void clearall(ActionEvent event) {
        finalbill.setText("");
        Discount_Amt.setText("");
        finalPrice.setText("");
        visa.setSelected(true);
        XYZ.setSelected(false);
        ABC.setSelected(false);
    }

    @FXML
    void exitsystem(ActionEvent event) {
        System.out.println(visa.selectedProperty());
        JOptionPane.showMessageDialog(null, "Thank You for shopping", "ABC Shopping Mall", 1);
        System.exit(0);
    }

}
