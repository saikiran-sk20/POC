package com.capgemini.tmobile.controller;

import java.net.HttpURLConnection;

import com.capgemini.tmobile.service.BillingAccountService;
import com.capgemini.tmobile.VO.BillingAccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BillingAccountController {

    @Autowired
    private BillingAccountService service;

    @ApiOperation(value = "This method is used for getting the Billing Account Information by AccountID!.")
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Billing Account Information is fetched  Successfully!"),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Billing Account Information ") })
    @GetMapping(value = "/api-service/v1/billing/account/{accountID}", produces = "application/json")
    public ResponseEntity<?> getBillingAccountInfoByAccountID(@PathVariable(required=true,value="accountID")String accountId) {
        if (accountId != null && accountId.length() > 0) {
            return new ResponseEntity(service.getBillingAccountInfoByAccountID(Integer.parseInt(accountId)), HttpStatus.OK);
        }
        return null;

    }

    @ApiOperation(value = "This method is used for Saving the Billing Account Information!. ")
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Billing Account Information is saved Successfully!"),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Error Occurred while processing the request! ") })
    @PostMapping(value = "/api-service/v1/billing/account/save", produces = "application/json")
    public ResponseEntity<?> saveBillingAccountInfo(@RequestBody BillingAccountVO billingAccountVO) {
        if (billingAccountVO != null && billingAccountVO.getAccountID() != null)
            try {
                billingAccountVO =service.saveBillingAccountInfo(billingAccountVO);
                return new ResponseEntity(billingAccountVO, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity("Error Occurred while processing!", HttpStatus.BAD_REQUEST);
            }
        return null;
    }

    @ApiOperation(value = "This method is used for Updating the Billing Account Information!. ")
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Billing Account Information is saved Successfully!"),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Error Occurred while processing the request! ") })
    @PutMapping(value = "/v1/billing/account/update", produces = "application/json")
    public ResponseEntity<?> updateBillingAccountInfo(@RequestBody BillingAccountVO billingAccountVO) {
        if (billingAccountVO != null && billingAccountVO.getAccountID() != null)
            try {
            	BillingAccountVO byId =service.getBillingAccountInfoByAccountID(billingAccountVO.getAccountID());
            	byId.setCustomerID(billingAccountVO.getCustomerID());
            	byId.setCurrentBalance(billingAccountVO.getCurrentBalance());
            	byId.setUnbilledCredits(billingAccountVO.getUnbilledCredits());
            	byId.setUnbilledDebits(billingAccountVO.getUnbilledDebits());
            	byId.setUnbilledPayments(billingAccountVO.getUnbilledPayments());
                billingAccountVO = service.updateBillingAccountInfo(byId);
                return new ResponseEntity(billingAccountVO, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity("Error Occurred while processing!", HttpStatus.BAD_REQUEST);
            }
        return null;
    }

}
