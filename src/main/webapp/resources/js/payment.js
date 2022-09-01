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

})