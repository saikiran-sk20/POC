
package com.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

/*import java.net.HttpURLConnection;
import java.util.logging.Logger;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;*/

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.service.PaymentService;

import io.swagger.annotations.ApiOperation;

@RestController
public class BillingPaymentController {

	@Autowired
	private PaymentService service;

	@ApiOperation(value = "This method is used for processing the payment!.")
	@PostMapping(value = "/v1/billing/account/payment", produces = "application/json")
	public ResponseEntity<?> processPayment(@RequestBody(required = true) PaymentVO payment) {
		if (payment.getCustomerId() != null) {
			return new ResponseEntity(service.processPayment(payment), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Error Occurred while processing the request!", HttpStatus.BAD_REQUEST);
		}
	}

}

/*
 * // private static final Logger logger =
 * Logger.getLogger(BillingPaymentController.class);
 * 
 * @Autowired private PaymentRepositoryDAO service;
 * 
 * @ApiOperation(value =
 * "This method is used for Adding the  Billing account Payment Information! ")
 * 
 * @ApiResponses(value = {
 * 
 * @ApiResponse(code = HttpURLConnection.HTTP_OK, message =
 * "Payment  Data is added Sucessfully!"),
 * 
 * @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message =
 * "Error Occurred while processing the request! ") })
 * 
 * @PostMapping(value = "/api-service/v1/billing/account/payment/save", produces
 * = "application/json") public ResponseEntity
 * savePayment(@RequestBody(required=true) PaymentVO payment) { try {
 * payment.setStatus(Iconstants.ACTIVE); service.save(payment); return new
 * ResponseEntity(payment, HttpStatus.OK); } catch (Exception e) {
 * System.out.println(e.getMessage()); return new
 * ResponseEntity("Error adding the Payment Information.",
 * HttpStatus.BAD_REQUEST); } }
 * 
 * @ApiOperation(value =
 * "This method is used for Deleting the  Billing Payment information. ")
 * 
 * @ApiResponses(value = {
 * 
 * @ApiResponse(code = HttpURLConnection.HTTP_OK, message =
 * "Billing Payment Information is deleted Sucessfully!"),
 * 
 * @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message =
 * "Error Occurred while processing the request! ") })
 * 
 * @PutMapping(value = "/v1/billing/account/payment/delete/{paymentId}",
 * produces = "application/json") public ResponseEntity
 * deletePayment(@PathVariable(required=true) Integer paymentId) { try {
 * service.deletePayment(paymentId , Iconstants.INACTIVE); return new
 * ResponseEntity(service.findOne(paymentId), HttpStatus.OK); } catch (Exception
 * e) { System.out.println(e.getMessage()); return new
 * ResponseEntity("Error Deleting Payment Information.",
 * HttpStatus.BAD_REQUEST);
 * 
 * }
 * 
 * }
 * 
 * @ApiOperation(value =
 * "This method is used for Updating the  Payment Information!. ")
 * 
 * @ApiResponses(value = {
 * 
 * @ApiResponse(code = HttpURLConnection.HTTP_OK, message =
 * "Payment Information is saved Sucessfully!"),
 * 
 * @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message =
 * "Error Occurred while processing the request! ") })
 * 
 * @PutMapping(value = "/v1/billing/account/payment/update", produces =
 * "application/json") public ResponseEntity
 * updatePayment(@RequestBody(required=true) PaymentVO paymentVo) { try {
 * service.save(paymentVo); return new ResponseEntity(paymentVo, HttpStatus.OK);
 * } catch (Exception e) { return new ResponseEntity("Error updating payment",
 * HttpStatus.BAD_REQUEST); } }
 * 
 * @ApiOperation(value =
 * "This method is used for getting the Payment Information!.")
 * 
 * @ApiResponses(value = {
 * 
 * @ApiResponse(code = HttpURLConnection.HTTP_OK, message =
 * " Billing Payment Data is fetched as Success!"),
 * 
 * @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message =
 * "Error occured while Processing the Payment! ") })
 * 
 * @GetMapping(value = "/api-service/v1/billing/account/payment/{paymentId}",
 * produces = "application/json") public ResponseEntity
 * getPayment(@PathVariable(required=true) Integer paymentId) { if (paymentId >
 * 0) { return new ResponseEntity(service.findOne(paymentId), HttpStatus.OK); }
 * else { return new
 * ResponseEntity("Error finding the Customer payment Information",
 * HttpStatus.BAD_REQUEST); } }
 * 
 * }
 */