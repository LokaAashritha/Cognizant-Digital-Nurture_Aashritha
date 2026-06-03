USE event_portal;

INSERT INTO users
(user_id, full_name, email, city, registration_date)
VALUES
(1,'Aashritha','aash@gmail.com','Hyderabad','2024-12-01'),
(2,'Shruthi','shruthi@gmail.com','Nizamabad','2024-12-05'),
(3,'Arjun','arjun@gmail.com','Kamareddy','2024-12-10'),
(4,'Ishitha','mymail@gmail.com','Nizamabad','2025-01-15'),
(5,'Divya','divya@gmail.com','Hyderabad','2025-02-01'),
(6,'Rahul','rahul@gmail.com','Hyderabad',CURDATE()),
(7,'Sneha','sneha@gmail.com','Nizamabad',CURDATE()),
(8,'Pranavi','pranavi@gmail.com','Hyderabad',CURDATE());

INSERT INTO events
(event_id, title, description, city, start_date, end_date, status, organizer_id)
VALUES
(1,'Tech Vision Summit',
'Technology networking and innovation event',
'Hyderabad',
'2025-06-10 10:00:00',
'2025-06-10 16:00:00',
'upcoming',
1),

(2,'AI Revolution Conference',
'Conference focused on AI and Machine Learning',
'Kamareddy',
'2025-05-15 09:00:00',
'2025-05-15 17:00:00',
'completed',
3),

(3,'Frontend Development Workshop',
'Hands-on frontend development training',
'Nizamabad',
'2025-07-01 10:00:00',
'2025-07-03 16:00:00',
'upcoming',
2),

(4,'Java Developer Meetup',
'Java discussion and networking event',
'Hyderabad',
'2025-08-10 10:00:00',
'2025-08-10 15:00:00',
'upcoming',
1),

(5,'Database Workshop',
'MySQL learning and practical sessions',
'Nizamabad',
'2025-09-05 09:00:00',
'2025-09-05 17:00:00',
'upcoming',
2);

INSERT INTO sessions
(session_id, event_id, title, speaker_name, start_time, end_time)
VALUES
(1,1,'Opening Keynote','Dr. Reddy',
'2025-06-10 10:00:00',
'2025-06-10 11:00:00'),

(2,1,'Future of Web Technologies','Aashritha',
'2025-06-10 11:15:00',
'2025-06-10 12:30:00'),

(3,2,'AI in Healthcare','Arjun',
'2025-05-15 09:30:00',
'2025-05-15 11:00:00'),

(4,3,'Introduction to HTML5','Shruthi',
'2025-07-01 10:00:00',
'2025-07-01 12:00:00'),

(5,1,'Cloud Computing','Kiran',
'2025-06-10 11:00:00',
'2025-06-10 12:00:00'),

(6,3,'Advanced CSS','Shruthi',
'2025-07-01 13:00:00',
'2025-07-01 15:00:00');

INSERT INTO registrations
(registration_id, user_id, event_id, registration_date)
VALUES
(1,1,1,'2025-05-01'),
(2,2,1,'2025-05-02'),
(3,3,2,'2025-04-30'),
(4,4,2,'2025-04-28'),
(5,5,3,'2025-06-15');

INSERT INTO feedback
(feedback_id, user_id, event_id, rating, comments, feedback_date)
VALUES
(1,3,2,4,'Excellent AI session','2025-05-16'),
(2,4,2,5,'Very informative and useful','2025-05-16'),
(3,2,1,3,'Good event but can be improved','2025-06-11'),
(4,1,2,5,'Excellent','2025-05-16'),
(5,2,2,4,'Good','2025-05-16'),
(6,5,2,5,'Amazing','2025-05-16'),
(7,5,1,2,'Poor organization','2025-06-11');

INSERT INTO resources
(resource_id, event_id, resource_type, resource_url, uploaded_at)
VALUES
(1,1,'pdf',
'https://portal.com/resources/tech_vision_agenda.pdf',
'2025-05-01 10:00:00'),

(2,2,'image',
'https://portal.com/resources/ai_conference_poster.jpg',
'2025-04-20 09:00:00'),

(3,3,'link',
'https://portal.com/resources/frontend_docs',
'2025-06-25 15:00:00');