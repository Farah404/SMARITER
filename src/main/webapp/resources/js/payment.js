window.addEventListener('load', function () {
	const form = document.getElementById('payment-form');
const token = document.getElementById('client-authorization');
const dropcontainer = document.getElementById('dropin-container');   
   braintree.dropin.create({
     authorization: token,
     container: dropcontainer
   }, (error, dropinInstance) => {
     if (error) console.error(error);
     form.addEventListener('submit', event => {
       event.preventDefault();
       dropinInstance.requestPaymentMethod((error, payload) => {
         if (error) console.error(error);
         document.getElementById('nonce').value = payload.nonce;
         form.submit();
       });
     });
   });

  braintree.client.create({
	  authorization: token
	}, function (err, clientInstance) {
	  // Creation of any other components...

	  braintree.dataCollector.create({
	    client: clientInstance
	  }, function (err, dataCollectorInstance) {
	    if (err) {
	      // Handle error in creation of data collector
	      return;
	    }
	    // At this point, you should access the dataCollectorInstance.deviceData value and provide it
	    // to your server, e.g. by injecting it into your form as a hidden input.
	    var deviceData = dataCollectorInstance.deviceData;
	    document.getElementById('deviceData').value= deviceData;
	  });
	});
})