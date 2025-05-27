const quizData = [
  {
    question: "What is the capital of France?",
    a: "Berlin",
    b: "Madrid",
    c: "Paris",
    d: "Rome",
    correct: "c"
  },
  {
    question: "How many planet are there in our solar System",
    a: "4",
    b: "8",
    c: "9",
    d: "7",
    correct: "b"
  },
  {
    question: "What is 2 + 2?",
    a: "3",
    b: "4",
    c: "5",
    d: "2",
    correct: "b"
  },
   {
    question: "Which language is used in styling a webpage",
    a: "Html",
    b: "Java",
    c: "Css",
    d: "Python",
    correct: "c"
  },
   {
    question: "how many sense organs does a human have ",
    a: "3",
    b: "4",
    c: "5",
    d: "6",
    correct: "c"
  },
   {
    question: "What is the name of the brain lobe responsible for sight",
    a: "Occipital",
    b: "Temporal",
    c: "Frontal",
    d: "Parietal",
    correct: "a"
  },
   {
    question: "What is 2 + 15?",
    a: "3",
    b: "17",
    c: "215",
    d: "512",
    correct: "b"
  },
];

let currentQuestion = 0;
let score = 0;

function loadQuestion() {
  const questionEl = document.getElementById('question');
  const buttons = document.querySelectorAll('.option-btn');
  const currentQuiz = quizData[currentQuestion];

  questionEl.innerText = currentQuiz.question;
  buttons[0].innerText = currentQuiz.a;
  buttons[1].innerText = currentQuiz.b;
  buttons[2].innerText = currentQuiz.c;
  buttons[3].innerText = currentQuiz.d;
}

function selectAnswer(answer) {
  const correct = quizData[currentQuestion].correct;
  if (answer === correct) {
    score++;
  }
  document.querySelectorAll('.option-btn').forEach(btn => btn.disabled = true);
}

function previousQuestion() {
   if (currentQuestion > 0) {
        currentQuestion--;
        loadQuestion();
    }
}

function nextQuestion() {
  currentQuestion++;
  if (currentQuestion < quizData.length) {
    document.querySelectorAll('.option-btn').forEach(btn => btn.disabled = false);
    loadQuestion();
  } else {
    document.getElementById('quiz').innerHTML = `
      <h2>You scored ${score}/${quizData.length}</h2>
      <button onclick="location.reload()">Reload</button>
    `;
  }
}

loadQuestion();