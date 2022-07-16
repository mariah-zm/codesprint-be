CREATE TABLE "quiz" (
  "id" varchar(20) PRIMARY KEY,
  "name" varchar(50),
  "description" varchar(250),
  "passing_score" int,
  "show_correct" boolean,
  "msg_fail" varchar(100),
  "msg_success" varchar(100)
);

CREATE TABLE "quiz_question" (
  "quiz_id" varchar(20),
  "ques_number" int,
  "question" text,
  "ques_type" int,
  PRIMARY KEY ("quiz_id", "ques_number"),
  CONSTRAINT fk_quiz FOREIGN KEY(quiz_id) REFERENCES quiz("id")
);

CREATE TABLE "quiz_answer" (
  "quiz_id" varchar(20),
  "ques_number" int,
  "ans_number" int,
  "answer" varchar(70),
  "score" int,
  "is_correct" boolean,
  PRIMARY KEY ("quiz_id", "ques_number", "ans_number")
);

CREATE TABLE "user" (
  "email" text PRIMARY KEY,
  "name" text,
  "type" int
);

INSERT INTO "quiz"
VALUES ('math', 'Maths Quiz', 'This is a quiz about numbers.', 3, true, 'Oh no! You failed.', 'Hooray! You did it.'),
('space', 'Planets Quiz', 'This is a quiz about planets.', 3, true, 'Oh no! You failed.', 'Hooray! You did it.');

INSERT INTO "quiz_question" 
VALUES ('math', 1, 'What is 1 + 1?', 1),
('math', 2, 'Which of these numbers are even?', 2),
('math', 3, 'A triangles has 3 sides.', 3),
('space', 1, 'Which planets are further away from the sun than Earth?', 2),
('space', 2, 'The sun is a planet.', 3),
('space', 3, 'Mercury is the planet closest to the sun.', 3);

INSERT INTO "quiz_answer"
VALUES ('math', 1, 1, '3', 0, false),
('math', 1, 2, '2', 1, true),
('math', 2, 1, '4', 1, true),
('math', 2, 2, '3', 0, false),
('math', 2, 3, '8', 1, true),
('math', 3, 1, 'True', 1, true),
('math', 3, 2, 'False', 0, false);

INSERT INTO "quiz_answer"
VALUES ('space', 1, 1, 'Mars', 1, true),
('space', 1, 2, 'Venus', 0, false),
('space', 1, 3, 'Jupiter', 1, true),
('space', 1, 4, 'Mercury', 0, false),
('space', 2, 1, 'True', 0, false),
('space', 2, 2, 'False', 1, true),
('space', 3, 1, 'True', 1, true),
('space', 3, 2, 'False', 0, false);
