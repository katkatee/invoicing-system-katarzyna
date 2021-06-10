CREATE TABLE public.invoice
(
    id       bigserial             NOT NULL,
    "date"   date                  NOT NULL,
    "number" character varying(50) NOT NULL,
    buyer    bigint                NOT NULL,
    seller   bigint                NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.company
(
    id                bigserial              NOT NULL,
    address           character varying(200) NOT NULL,
    name              character varying(100) NOT NULL,
    pension_insurance numeric(10, 2)         NOT NULL DEFAULT 0,
    health_insurance  numeric(10, 2)         NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

CREATE TABLE public.car
(
    id                  bigserial             NOT NULL,
    registration_number character varying(20) NOT NULL,
    personal_user       boolean               NOT NULL DEFAULT false,
    PRIMARY KEY (id)
);

CREATE TABLE public.vat
(
    id   bigserial     NOT NULL,
    name character varying(20),
    rate numeric(3, 2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.invoice_entry
(
    id                     bigserial      NOT NULL,
    description            character varying(50),
    quantity               numeric(10, 2) NOT NULL DEFAULT 1,
    net_price              numeric(10, 2) NOT NULL,
    vat_value              numeric(10, 2) NOT NULL,
    vat_rate               bigint         NOT NULL,
    expense_related_to_car bigint,
    PRIMARY KEY (id)
);

CREATE TABLE public.invoice_invoice_entry
(
    invoice_id       bigint NOT NULL,
    invoice_entry_id bigint NOT NULL,
    PRIMARY KEY (invoice_id, invoice_entry_id)
);

ALTER TABLE public.invoice
    ADD CONSTRAINT buyer_fk FOREIGN KEY (buyer)
        REFERENCES public.company (id);

ALTER TABLE public.invoice
    ADD CONSTRAINT seller_fk FOREIGN KEY (seller)
        REFERENCES public.company (id);

ALTER TABLE public.invoice_entry
    ADD CONSTRAINT vat_rate_fk FOREIGN KEY (vat_rate)
        REFERENCES public.vat (id);

ALTER TABLE public.invoice_entry
    ADD CONSTRAINT car_fk FOREIGN KEY (expense_related_to_car)
        REFERENCES public.car (id);

ALTER TABLE public.invoice_invoice_entry
    ADD CONSTRAINT invoice_id_fk FOREIGN KEY (invoice_id)
        REFERENCES public.invoice (id);

ALTER TABLE public.invoice_invoice_entry
    ADD CONSTRAINT invoice_entry_id_fk FOREIGN KEY (invoice_entry_id)
        REFERENCES public.invoice_entry (id);

insert into public.vat (name, rate)
values ('23', 0.23),
       ('8', 0.08),
       ('5', 0.05),
       ('0', 0.00),
       ('ZW', 0.00);

ALTER TABLE public.vat
    OWNER to postgres;

ALTER TABLE public.company
    OWNER to postgres;

ALTER TABLE public.car
    OWNER to postgres;

ALTER TABLE public.invoice_entry
    OWNER to postgres;

ALTER TABLE public.invoice_invoice_entry
    OWNER to postgres;
