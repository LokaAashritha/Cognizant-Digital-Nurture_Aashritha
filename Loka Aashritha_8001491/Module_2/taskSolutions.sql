-- =========================================
-- Exercise 1 : User Upcoming Events
-- =========================================

SELECT
    u.full_name,
    e.title,
    e.city,
    e.start_date
FROM users u
JOIN registrations r
    ON u.user_id = r.user_id
JOIN events e
    ON r.event_id = e.event_id
WHERE e.status = 'upcoming'
  AND u.city = e.city
ORDER BY e.start_date;

-- =========================================
-- Exercise 2 : Top Rated Events
-- =========================================

SELECT
    e.event_id,
    e.title,
    ROUND(AVG(f.rating),2) AS avg_rating,
    COUNT(f.feedback_id) AS feedback_count
FROM events e
JOIN feedback f
    ON e.event_id = f.event_id
GROUP BY e.event_id,e.title
HAVING COUNT(f.feedback_id) >= 3
ORDER BY avg_rating DESC;

-- =========================================
-- Exercise 3 : Inactive Users
-- =========================================

SELECT
    u.user_id,
    u.full_name,
    u.email
FROM users u
LEFT JOIN registrations r
    ON u.user_id = r.user_id
    AND r.registration_date >= CURDATE() - INTERVAL 90 DAY
WHERE r.registration_id IS NULL;

-- =========================================
-- Exercise 4 : Peak Session Hours
-- =========================================

SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id) AS session_count
FROM events e
LEFT JOIN sessions s
    ON e.event_id = s.event_id
WHERE TIME(s.start_time)
      BETWEEN '10:00:00' AND '12:00:00'
GROUP BY e.event_id,e.title;

-- =========================================
-- Exercise 5 : Most Active Cities
-- =========================================

SELECT
    u.city,
    COUNT(DISTINCT r.registration_id) AS total_registrations
FROM users u
JOIN registrations r
    ON u.user_id = r.user_id
GROUP BY u.city
ORDER BY total_registrations DESC
LIMIT 5;

-- =========================================
-- Exercise 6 : Event Resource Summary
-- =========================================

SELECT
    e.event_id,
    e.title,
    COUNT(r.resource_id) AS total_resources
FROM events e
LEFT JOIN resources r
    ON e.event_id = r.event_id
GROUP BY e.event_id,e.title;

-- =========================================
-- Exercise 7 : Low Feedback Alerts
-- =========================================

SELECT
    u.full_name,
    e.title,
    f.rating,
    f.comments
FROM feedback f
JOIN users u
    ON f.user_id = u.user_id
JOIN events e
    ON f.event_id = e.event_id
WHERE f.rating < 3;

-- =========================================
-- Exercise 8 : Sessions per Upcoming Event
-- =========================================

SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id) AS total_sessions
FROM events e
LEFT JOIN sessions s
    ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id,e.title;

-- =========================================
-- Exercise 9 : Organizer Event Summary
-- =========================================

SELECT
    u.full_name AS organizer,
    e.status,
    COUNT(*) AS total_events
FROM users u
JOIN events e
    ON u.user_id = e.organizer_id
GROUP BY u.full_name,e.status
ORDER BY u.full_name;

-- =========================================
-- Exercise 10 : Feedback Gap
-- =========================================

SELECT
    e.event_id,
    e.title
FROM events e
JOIN registrations r
    ON e.event_id = r.event_id
LEFT JOIN feedback f
    ON e.event_id = f.event_id
WHERE f.feedback_id IS NULL
GROUP BY e.event_id,e.title;

-- =========================================
-- Exercise 11 : Daily New User Count
-- =========================================

SELECT
    registration_date,
    COUNT(*) AS total_users
FROM users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date
ORDER BY registration_date;

-- =========================================
-- Exercise 12 : Event With Maximum Sessions
-- =========================================

SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id) AS session_count
FROM events e
LEFT JOIN sessions s
    ON e.event_id = s.event_id
GROUP BY e.event_id,e.title
HAVING COUNT(s.session_id) =
(
    SELECT MAX(session_total)
    FROM
    (
        SELECT COUNT(*) AS session_total
        FROM sessions
        GROUP BY event_id
    ) AS session_counts
);

-- =========================================
-- Exercise 13 : Average Rating Per City
-- =========================================

SELECT
    e.city,
    ROUND(AVG(f.rating),2) AS average_rating
FROM events e
JOIN feedback f
    ON e.event_id = f.event_id
GROUP BY e.city;

-- =========================================
-- Exercise 14 : Most Registered Events
-- =========================================

SELECT
    e.event_id,
    e.title,
    COUNT(r.registration_id) AS registration_count
FROM events e
LEFT JOIN registrations r
    ON e.event_id = r.event_id
GROUP BY e.event_id,e.title
ORDER BY registration_count DESC
LIMIT 3;

-- =========================================
-- Exercise 15 : Event Session Time Conflict
-- =========================================

SELECT
    s1.event_id,
    s1.title AS session_1,
    s2.title AS session_2,
    s1.start_time,
    s1.end_time,
    s2.start_time,
    s2.end_time
FROM sessions s1
JOIN sessions s2
    ON s1.event_id = s2.event_id
   AND s1.session_id < s2.session_id
WHERE s1.start_time < s2.end_time
  AND s1.end_time > s2.start_time;

-- =========================================
-- Exercise 16 : Unregistered Active Users
-- =========================================

SELECT
    u.user_id,
    u.full_name,
    u.email
FROM users u
LEFT JOIN registrations r
    ON u.user_id = r.user_id
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
  AND r.registration_id IS NULL;

-- =========================================
-- Exercise 17 : Multi Session Speakers
-- =========================================

SELECT
    speaker_name,
    COUNT(*) AS total_sessions
FROM sessions
GROUP BY speaker_name
HAVING COUNT(*) > 1;

-- =========================================
-- Exercise 18 : Resource Availability Check
-- =========================================

SELECT
    e.event_id,
    e.title
FROM events e
LEFT JOIN resources r
    ON e.event_id = r.event_id
WHERE r.resource_id IS NULL;

-- =========================================
-- Exercise 19 : Completed Events With Feedback Summary
-- =========================================

SELECT
    e.event_id,
    e.title,
    COUNT(DISTINCT r.registration_id) AS total_registrations,
    ROUND(AVG(f.rating),2) AS average_rating
FROM events e
LEFT JOIN registrations r
    ON e.event_id = r.event_id
LEFT JOIN feedback f
    ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id,e.title;

-- =========================================
-- Exercise 20 : User Engagement Index
-- =========================================

SELECT
    u.user_id,
    u.full_name,
    COUNT(DISTINCT r.event_id) AS events_attended,
    COUNT(DISTINCT f.feedback_id) AS feedbacks_submitted
FROM users u
LEFT JOIN registrations r
    ON u.user_id = r.user_id
LEFT JOIN feedback f
    ON u.user_id = f.user_id
GROUP BY u.user_id,u.full_name
ORDER BY events_attended DESC;

-- =========================================
-- Exercise 21 : Top Feedback Providers
-- =========================================

SELECT
    u.user_id,
    u.full_name,
    COUNT(f.feedback_id) AS feedback_count
FROM users u
JOIN feedback f
    ON u.user_id = f.user_id
GROUP BY u.user_id,u.full_name
ORDER BY feedback_count DESC
LIMIT 5;

-- =========================================
-- Exercise 22 : Duplicate Registrations Check
-- =========================================

SELECT
    user_id,
    event_id,
    COUNT(*) AS registration_count
FROM registrations
GROUP BY user_id,event_id
HAVING COUNT(*) > 1;

-- =========================================
-- Exercise 23 : Registration Trends
-- =========================================

SELECT
    DATE_FORMAT(registration_date,'%Y-%m') AS registration_month,
    COUNT(*) AS total_registrations
FROM registrations
GROUP BY DATE_FORMAT(registration_date,'%Y-%m')
ORDER BY registration_month;

-- =========================================
-- Exercise 24 : Average Session Duration Per Event
-- =========================================

SELECT
    e.event_id,
    e.title,
    ROUND(
        AVG(
            TIMESTAMPDIFF(
                MINUTE,
                s.start_time,
                s.end_time
            )
        ),
        2
    ) AS avg_duration_minutes
FROM events e
JOIN sessions s
    ON e.event_id = s.event_id
GROUP BY e.event_id,e.title;

-- =========================================
-- Exercise 25 : Events Without Sessions
-- =========================================

SELECT
    e.event_id,
    e.title
FROM events e
LEFT JOIN sessions s
    ON e.event_id = s.event_id
WHERE s.session_id IS NULL;