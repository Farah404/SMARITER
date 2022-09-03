window.addEventListener('load', function() {


	const REPLY_LIST = [
		{
			userKeywords: ["help", "iter", "hi"],
			replyMessage: "We can chat about the following topics: Building a website, Smariter services, Smariter terms of use and Payment solutions."
		},
		{
			userKeywords: ["building", "website"],
			replyMessage: "You want to provide carpooling services to your members ? SMARITER provides you many options to define your own website. You can either choose every options from scratch or select a pre-defined website template. Please visit the website builder section to get started !"
		},
		{
			userKeywords: ["solution", "service", "carpool", "parcel", "personal", "rental"],
			replyMessage: "Showcase and offer your services with a professional online scheduling platform. Streamline your business by managing your schedule with an all-in-one booking solution."
		},
		{
			userKeywords: ["terms", "use"],
			replyMessage: "Smariter has a very detailed Terms of use page. You can find the link to that in the footer section under the column product "
		},
		{
			userKeywords: ["payment", "financial"],
			replyMessage: "Smariter lets clients pay with cash, credit or digital wallets. Connect to your preferred payment provider and manage all transactions and finances from one integrated dashboard. build your website today!"
		}
	];
	const availableKeywords = REPLY_LIST.reduce((keywords, reply) => {
		for (let keyword of reply.userKeywords) {
			keywords.push(keyword);
		}
		return keywords;
	}, []);

	document.getElementById("chat-icon").onclick = openChat;
	document.getElementById("chat-exit").onclick = closeChat;
	document.getElementById("send-msg-icon").onclick = handleMessage;
	document.getElementById("chat-user-message").addEventListener("keyup", function(event) {
		// Number 13 is the "Enter" key on the keyboard
		if (event.keyCode === 13) {
			event.preventDefault();
			document.getElementById("send-msg-icon").click();
		}
	});

	let isChatOpen = false;

	document.getElementById("chat-box").addEventListener('animationend', () => {
		if (isChatOpen) {
			document.getElementById("chat-exit").style.display = 'block';
			document.getElementById("chat-header").style.display = 'block';
			document.getElementById("chat-history-wrapper").style.display = 'block';
			document.getElementById("chat-user-inputs").style.display = 'block';

			if (document.getElementById("chat-history").innerHTML.trim() === "") {
				// Opening chat for first time
				reply(greetUser());
			}
		} else {
			document.getElementById("chat-icon").style.display = 'block';
		}
	});

	function openChat() {
		document.getElementById("chat-icon").style.display = 'none';
		document.getElementById("chat-box").style.display = 'block';
		document.getElementById("chat-box").classList.add("showBox");
		isChatOpen = true;
	}

	function closeChat() {
		document.getElementById("chat-box").classList.remove("showBox");
		document.getElementById("chat-box").classList.add("hideBox");

		document.getElementById("chat-exit").style.display = 'none';
		document.getElementById("chat-header").style.display = 'none';
		document.getElementById("chat-history-wrapper").style.display = 'none';
		document.getElementById("chat-user-inputs").style.display = 'none';
		isChatOpen = false;
	}

	let hasBeenGreeted = false;
	function handleMessage() {
		let userMsg = document.getElementById('chat-user-message').value;
		document.getElementById('chat-user-message').value = "";
		logUserMessage(userMsg);
		userMsg = userMsg.toLowerCase();

		// A little existentialist joke if user greets the bot
		if (userMsg.includes("hello")) {
			if (!hasBeenGreeted) {
				hasBeenGreeted = true;
				reply("Hello There. My name is ITER and I am at your service. Type help for a list of the available topics.");
			} else {
				reply(greetUser());
			}
		}
		else if (userMsg.includes('joke')) {
			joke();
		} else if (availableKeywords.some(keyword => userMsg.includes(keyword))) {
			// Business logic responses
			REPLY_LIST.forEach(replyObj => {
				if (replyObj.userKeywords.some(keyword => userMsg.includes(keyword))) {
					reply(replyObj.replyMessage);
				}
			});
		} else {
			// Fallthrough
			reply("I'm sorry I did not understand your message. Type 'help' for a list of topics I like to talk about. Here's a joke to make you feel better!");
			joke();
		}

	}

	const JOKES_ENDPOINT = "https://v2.jokeapi.dev/joke/Programming?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=single";
	function joke() {
		fetch(JOKES_ENDPOINT)
			.then(response => response.json())
			.then(joke => {
				if (joke.error === "true") {
					reply("I'm sorry I can't think of a joke at this moment 🙃");
				} else {
					reply(joke.joke + ' 🤣');
				}
			}).catch(err => {
				reply("Robot cannot compute. No, seriously... would you mind letting my developer know? 🥺");
			});
	}

	function reply(message) {
		let htmlReply = '<div class="chat-reply"><img src="media/img/3649460.png" class="chat-reply-logo" /><p>'
			+ message
			+ "</p></div>";

		document.getElementById("chat-history").innerHTML += htmlReply;
		const chatHistoryWrapper = document.getElementById("chat-history-wrapper");
		chatHistoryWrapper.scrollTop = chatHistoryWrapper.scrollHeight;
	}

	function logUserMessage(message) {
		let htmlMessage = '<div class="user-msg"><p>'
			+ message
			+ "</p></div>";

		document.getElementById("chat-history").innerHTML += htmlMessage;
		const chatHistoryWrapper = document.getElementById("chat-history-wrapper");
		chatHistoryWrapper.scrollTop = chatHistoryWrapper.scrollHeight;
	}

	function greetUser() {
		return "I am here to answer all of your questions! Type 'help' for a list of the available topics. I also love to tell jokes!"
	}





})