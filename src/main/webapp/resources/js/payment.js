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




// A way to bypass the payment pb ? using hosted fields :
// https://developer.paypal.com/braintree/docs/guides/hosted-fields/setup-and-integration

//window.addEventListener('load', function () {
//	const form = document.getElementById('payment-form');
//const token = document.getElementById('client-authorization');   
//   braintree.client.create({
//        authorization: token
//      }, function (clientErr, clientInstance) {
//        if (clientErr) {
//          console.error(clientErr);
//          return;
//        }
//
//        braintree.hostedFields.create({
//          client: clientInstance,
//          styles: {
//            'input': {
//              'font-size': '14px'
//            },
//            'input.invalid': {
//              'color': 'red'
//            },
//            'input.valid': {
//              'color': 'green'
//            }
//          },
//          fields: {
//            number: {
//              container: '#card-number',
//              placeholder: '4111 1111 1111 1111'
//            },
//            cvv: {
//              container: '#cvv',
//              placeholder: '123'
//            },
//            expirationDate: {
//              container: '#expiration-date',
//              placeholder: '10/2022'
//            }
//          }
//        }, function (hostedFieldsErr, hostedFieldsInstance) {
//          if (hostedFieldsErr) {
//            console.error(hostedFieldsErr);
//            return;
//          }
//
//          
//
//          form.addEventListener('submit', function (event) {
//            event.preventDefault();
//
//            hostedFieldsInstance.tokenize(function (tokenizeErr, payload) {
//              if (tokenizeErr) {
//                console.error(tokenizeErr);
//                return;
//              }
//
//              // If this was a real integration, this is where you would
//              // send the nonce to your server.
//              document.getElementById('nonce').value = payload.nonce;
//              form.submit;
//            });
//          }, false);
//        });
//      });
//})
     