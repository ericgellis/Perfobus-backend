-- Create sequences --
CREATE SEQUENCE public.mobithink_uid
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

-- drop tables of link --
DROP TABLE IF EXISTS public."city_line_link";
DROP TABLE IF EXISTS public."event_place_link";
DROP TABLE IF EXISTS public."line_station_link";
DROP TABLE IF EXISTS public."line_trip_link";
DROP TABLE IF EXISTS public."place_station_data_link";
DROP TABLE IF EXISTS public."station_data_station_link";
DROP TABLE IF EXISTS public."station_data_trip_link";
DROP TABLE IF EXISTS public."trip_event_link";

-- drop entities tables --
DROP TABLE IF EXISTS public."bus_line";
DROP TABLE IF EXISTS public."city";
DROP TABLE IF EXISTS public."event";
DROP TABLE IF EXISTS public."place";
DROP TABLE IF EXISTS public."station";
DROP TABLE IF EXISTS public."station_data";
DROP TABLE IF EXISTS public."trip";

-- create tables of link --

CREATE TABLE public.city_line_link
(
    id bigint NOT NULL,
    city_id bigint NOT NULL,
    bus_line_id bigint NOT NULL,
    CONSTRAINT city_line_link_pkey PRIMARY KEY (id)
);

CREATE TABLE public.event_place_link
(
    id bigint NOT NULL,
    place_id bigint NOT NULL,
    event_id bigint NOT NULL,
    CONSTRAINT event_place_link_pkey PRIMARY KEY (id)
);

CREATE TABLE public.line_station_link
(
    id bigint NOT NULL,
    bus_line_id bigint NOT NULL,
    station_id bigint NOT NULL,
    CONSTRAINT line_sation_link_pkey PRIMARY KEY (id)
);

CREATE TABLE public.line_trip_link
(
    id bigint NOT NULL,
    bus_line_id bigint NOT NULL,
    trip_id bigint NOT NULL,
    CONSTRAINT line_trip_link_pkey PRIMARY KEY (id)
);

CREATE TABLE public.place_station_data_link
(
    id bigint NOT NULL,
    place_id bigint NOT NULL,
    station_data_id bigint NOT NULL,
    CONSTRAINT place_station_data_link_pkey PRIMARY KEY (id)
);

CREATE TABLE public.station_data_station_link
(
    id bigint NOT NULL,
    station_id bigint NOT NULL,
    station_data_id bigint NOT NULL,
    CONSTRAINT station_data_station_link_pkey PRIMARY KEY (id)
);

CREATE TABLE public.station_data_trip_link
(
    id bigint NOT NULL,
    station_data_id bigint NOT NULL,
    trip_id bigint NOT NULL,
    CONSTRAINT station_data_trip_link_pkey PRIMARY KEY (id)
);

CREATE TABLE public.trip_event_link
(
    id bigint NOT NULL,
    trip_id bigint NOT NULL,
    event_id bigint NOT NULL,
    CONSTRAINT trip_event_link_pkey PRIMARY KEY (id)
);


-- create entities tables --

CREATE TABLE public.bus_line
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    creation_date bigint NOT NULL,
    CONSTRAINT bus_line_pkey PRIMARY KEY (id)
);

CREATE TABLE public.city
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT city_pkey PRIMARY KEY (id)
);

CREATE TABLE public.event
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    start_time bigint NOT NULL,
    end_time bigint,
    start_place_id bigint NOT NULL,
    end_place_id bigint,
    station_id bigint,
    CONSTRAINT event_pkey PRIMARY KEY (id)
);

CREATE TABLE public.place
(
    id bigint NOT NULL,
    gps_lat bigint NOT NULL,
    gps_long bigint NOT NULL,
    CONSTRAINT place_pkey PRIMARY KEY (id)
);

CREATE TABLE public.station
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT station_pkey PRIMARY KEY (id)
);

CREATE TABLE public.station_data
(
    id bigint NOT NULL,
    come_in integer NOT NULL,
    go_out integer NOT NULL,
    start_time bigint NOT NULL,
    end_time bigint NOT NULL,
    step integer,
    CONSTRAINT station_data_pkey PRIMARY KEY (id)
);

CREATE TABLE public.trip
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    start_time bigint NOT NULL,
    end_time bigint NOT NULL,
    atmo integer,
    temperature integer,
    weather text COLLATE pg_catalog."default",
    direction text COLLATE pg_catalog."default",
    vehicle_capacity integer,
    CONSTRAINT trip_pkey PRIMARY KEY (id)
);