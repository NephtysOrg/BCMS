create table BCMS_session
(
session_id INT not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), -- Auto id
fire_truck_number integer ,
police_truck_number integer,
constraint BCMS_session_key primary key(session_id)
);

create table Event(
event_id INT not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), -- Auto id
event_occurrence_time time,
event_name varchar(50),
execution_trace varchar(500),
session_id INT,
constraint Event_key primary key(event_id),
constraint BCMS_session_foreign_key foreign key(session_id) references BCMS_session(session_id) on delete cascade);

create table Fire_truck(
fire_truck_name varchar(30),
constraint Fire_truck_key primary key(fire_truck_name));

create table Police_vehicle(
police_vehicle_name varchar(30),
constraint Police_vehicle_key primary key(police_vehicle_name));

create table Route(
route_name varchar(30),
constraint Route_key primary key(route_name));

create table BCMS_session_Fire_truck(
BCMS_session_Fire_truck_id INT not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),  -- Auto id
session_id INT,
fire_truck_name varchar(30),
fire_truck_status varchar(10) CONSTRAINT fire_truck_status_check CHECK (fire_truck_status IN ('Idle','Dispatched','Arrived','Blocked','Breakdown')),
constraint BCMS_session_Fire_truck_key primary key(BCMS_session_Fire_truck_id),
constraint BCMS_session_foreign_key2 foreign key(session_id) references BCMS_session(session_id) on delete cascade,
constraint Fire_truck_foreign_key foreign key(fire_truck_name) references Fire_truck(fire_truck_name) on delete cascade);

create table BCMS_session_Police_vehicle(
BCMS_session_Police_vehicle_id INT not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
session_id INT,
police_vehicle_name varchar(30),
police_vehicle_status varchar(10) CONSTRAINT police_vehicle_status_check CHECK (police_vehicle_status IN ('Idle','Dispatched','Arrived','Blocked','Breakdown')),
constraint BCMS_session_Police_vehicle_key primary key(BCMS_session_Police_vehicle_id),
constraint BCMS_session_foreign_key3 foreign key(session_id) references BCMS_session(session_id) on delete cascade,
constraint Police_vehicle_foreign_key foreign key(police_vehicle_name) references Police_vehicle(police_vehicle_name) on delete cascade);
