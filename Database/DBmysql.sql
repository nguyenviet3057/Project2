CREATE TABLE `permission` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `role` varchar(25)
);

CREATE TABLE `staff` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `fullname` varchar(60) NOT NULL,
  `birth` date,
  `phone` varchar(16),
  `address` varchar(200),
  `email` varchar(50),
  `password` varchar(30),
  `pic` varchar(150),
  `salary` float,
  `permission_id` int
);

CREATE TABLE `class` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(10) UNIQUE,
  `n_std` int,
  `staff_id` int
);

CREATE TABLE `subject` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(60),
  `session` int,
  `staff_id` int
);

CREATE TABLE `semester` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `semester_no` int,
  `subject_id` int,
  `start_year` date
);

CREATE TABLE `status` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `desc` varchar(20)
);

CREATE TABLE `students` (
  `rollno` int PRIMARY KEY,
  `fullname` varchar(60) NOT NULL,
  `birth` date,
  `phone` varchar(16),
  `address` varchar(200),
  `email` varchar(50),
  `password` varchar(30),
  `pic` varchar(150),
  `status_id` int,
  `semester_id` int,
  `class_id` int
);

CREATE TABLE `schedule` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `staff_id` int,
  `subject_id` int,
  `class_id` int,
  `start_date` date,
  `end_date` date
);

CREATE TABLE `booking` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `schedule_id` int,
  `begin_time` datetime,
  `end_time` datetime,
  `note` text
);

CREATE TABLE `attendance` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `booking_id` int,
  `attendance1` varchar(5),
  `attendance2` varchar(5),
  `note` text
);

CREATE TABLE `mark` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `subject_id` int,
  `student_rollno` varchar(10),
  `mark_t` float,
  `mark_p` float,
  `created_at` datetime
);

CREATE TABLE `notifications` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `staff_id` int,
  `content` text,
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `subclass` (
  `student_rollno` VARCHAR(10),
  `class_id` int
);

ALTER TABLE `staff` ADD FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`);

ALTER TABLE `class` ADD FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`);

ALTER TABLE `subject` ADD FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`);

ALTER TABLE `semester` ADD FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`class_id`) REFERENCES `class` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`semester_id`) REFERENCES `semester` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

ALTER TABLE `schedule` ADD FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`);

ALTER TABLE `schedule` ADD FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

ALTER TABLE `schedule` ADD FOREIGN KEY (`class_id`) REFERENCES `class` (`id`);

ALTER TABLE `booking` ADD FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`);

ALTER TABLE `attendance` ADD FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`);

ALTER TABLE `mark` ADD FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

ALTER TABLE `mark` ADD FOREIGN KEY (`student_rollno`) REFERENCES `students` (`rollno`);

ALTER TABLE `notifications` ADD FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`);

ALTER TABLE `subclass` ADD FOREIGN KEY (`student_rollno`) REFERENCES `students` (`rollno`);

ALTER TABLE `subclass` ADD FOREIGN KEY (`class_id`) REFERENCES `class` (`id`);
