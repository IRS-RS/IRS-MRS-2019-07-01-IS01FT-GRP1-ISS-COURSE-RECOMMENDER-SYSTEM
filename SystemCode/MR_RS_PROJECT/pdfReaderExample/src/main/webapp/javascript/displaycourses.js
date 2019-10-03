var courses = {
"2": {
	"h3":"Data Science",
	"h4":"Harness the full potential of data and analytics to gain a competitive edge in today’s business climate.",
	"p" : "ISS provides a comprehensive suite of Data Science courses that will empower participants with the capability to make data driven and evidence-based decisions. These assets are pivotal in the development of effective strategic solutions and the effort to achieve greater competitive advantage.The range of available courses includes the NICF- Statistics Bootcamp. This foundation course will equip participants with the capability to use R in their statistical analysis to facilitate more accurate and effective data-driven decisions. Another course on offer is the NICF- Social Media Analytics, an intermediate level course, where participant will acquire the skill to interpret social media data and produce effective actions based on the analytics."
},
"1": {
	"h3":"Artificial Intelligence",
	"h4":"Harness the full potential of data and analytics to gain a competitive edge in today’s business climate.",
	"p" : "ISS provides a comprehensive suite of Artificial Intelligence courses that will empower participants with the capability to make data driven and evidence-based decisions. These assets are pivotal in the development of effective strategic solutions and the effort to achieve greater competitive advantage.The range of available courses includes the NICF- Statistics Bootcamp. This foundation course will equip participants with the capability to use R in their statistical analysis to facilitate more accurate and effective data-driven decisions. Another course on offer is the NICF- Social Media Analytics, an intermediate level course, where participant will acquire the skill to interpret social media data and produce effective actions based on the analytics."
},
"4":{
	"h3":"CyberSecurity",
	"h4":"Protecting your organisation against cyberthreats in a hyper-connected world",
	"p" : "Current threats can range from the theft of intellectual property, customer and personal data to the disruption of businesses, and even threaten our physical safety should the critical infrastructures become targets of attack. NUS-ISS Cybersecurity courses equip ICT professionals with an understanding of the online threats that potentially affect the businesses functions and operations within your organisation.We offer a range of courses to provide the essential knowledge, tools and techniques to predict, prevent, detect, and respond to cyber threats. NUS-ISS is the only official training partner for (ISC)2 in Singapore and provides training for cybersecurity certifications such as the (ISC)2 CISSP, CCSP and CSSLP."
		
}, 
"3": {
	"h3":"Digital Strategy & Leadership",
	"h4":"Develop leadership and strategy capabilities to lead digital transformation in your organisation",
	"p" : "The pervasive use of digital technologies is disrupting conventional business models and giving rise to new ways of working. The roles of ICT professional have shifted from just being the implementer of IT solutions to a digital leader who is also a significant business partner and can lead and execute digitalisation and transformation for their organisation.  In the digital economy, a strong digital leadership is critical in enabling an organisation to take advantage of new opportunities, and stay ahead of the digital wave. NUS-ISS’ courses in Digital Strategy and Leadership provide participants with the essential strategic thinking skills, practices and mind-set for the digital age, some focus area include Digital Strategy & Transformation, Business Agility, Digital Architecture, Governance etc."
},
"5": {
	"h3":"Software Systems",
	"h4":"Immerse in world-class software development curriculum and training that connects research and practice.",
	"p" : "One of the tenets of software development is that skill beats scale every time. A small core team of highly skilled software architects and developers can indeed deliver high impact high resilience systems faster and better than a large team of less experienced workers.NUS-ISS offers an extensive range of core courses to equip IT professionals with the necessary and important tools to elevate their competency and increase their capabilities, enabling them to make even more significant contributions to their organisations.The Software Systems training curriculum is aligned with national focus areas and national training frameworks, which enables us to offer courses that are relevant and timely to the demands of today’s technology-driven business environments."
	
},
"6":{
	"h3":"Digital Products & Platforms",
	"h4":"Learn the best practices in managing digital products, platforms and projects.",
	"p" : "These professionals transverse the organisational barriers by integrating people and processes. They work in an agile manner to deliver the “right product to the right customers at the right time” to contribute to the business outcomes.NUS-ISS’ training roadmap for Digital Products & Platforms offers best practices and frameworks covering the strategy development and management of digital products, super-app platforms and digital projects. These courses equip business executives, digital product and platform professionals with the required skills in their digital product and platform journeys"
	
},
"7": {
		"h3":"Digital Innovation & Design",
		"h4":"Foster innovation and design thinking skills to elevate your organisation in a technology-driven environment.",
		"p" : "These professionals transverse the organisational barriers by integrating people and processes. They work in an agile manner to deliver the “right product to the right customers at the right time” to contribute to the business outcomes.NUS-ISS’ training roadmap for Digital Products & Platforms offers best practices and frameworks covering the strategy development and management of digital products, super-app platforms and digital projects. These courses equip business executives, digital product and platform professionals with the required skills in their digital product and platform journeys"
		
	},
"8":{
	"h3":"Digital Agility",
	"h4":"Using digital to foster business agility to respond to rapid changes in the market and business environment",
	"p":"Digital agility refers to the ability of an organisation to use digital and other enablers (such as leadership, culture, processes etc.) to rapidly adapt to market and environmental changes. In the digital age, such changes are occurring at an increasing velocity, volume and variety and can be disruptive to existing businesses. Hence, organisations need to be agile to respond and thrive in such an environment. This means not only being quick and flexible in taking action and executing initiatives, but also using digital and data to be hyper-aware and have early knowledge of environmental or market changes, then making fast data-informed or data-optimised decisions of what actions and initiatives to take. Such quick cycles of hyper-awareness, decision making and execution will not happen on its own but need people to have agile mindset and culture, led by agile leadership and having agile processes, organisation structure etc."
	},
"9":{
	"h3":"StackUp - Startup Tech Talent Development",
	"h4":"StackUp develop talents to become technologists at startups with aspirations to advance a smart digital world.",
	"p":"NUS-ISS has all the fundamentals to lead this movement where we create an eco-system to help build the tech caliber of Tech Startups. We are poised to amalgamate the disciplines using a 'whole-stack' approach to co-create the next engine of growth in Singapore with technologists for technologists.StackUp is a new curriculum conceived to transform individuals into aspiring technologists. It will equip students with the foundational skills required - from attitude and aptitude to technical competencies - to drive the development of market-relevant tech products from idea through to implementation.Designed to help new startups and SMEs that rely on open stack technologies, this programme offers the chance to participate in class, immerse in apprenticeships and apply newly-acquired principles and concepts to real-life projects."
},
"10":{
	"h3":"All Courses",
	"h4":"NUS ISS provides Executive Education in IT, offering Mtech, Graduate diploma, PMP and professional certification short courses in Singapore",
	"p":"Advance your career in Data Science,Artificial Intelligence,Cybersecurity,Digital Strategy & Leadership,Software Systems,Digital Products & Platforms,Digital Innovation & Design,Digital Agility,StackUp - Startup Tech Talent Development"}
}

document.getElementById("fieldsetoptions").style.display="none";

document.getElementById("options").onchange= function() {
	document.getElementById("fieldsetoptions").style.display="block";
	//var val =document.getElementById("parentcourse")[document.getElementById("parentcourse").value-1].text;
	document.getElementById("fieldseth3").innerHTML=courses[document.getElementById("options").value].h3
	document.getElementById("fieldseth4").innerHTML=courses[document.getElementById("options").value].h4
	document.getElementById("fieldsetp").innerHTML=courses[document.getElementById("options").value].p
}


