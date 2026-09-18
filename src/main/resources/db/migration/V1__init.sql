create table if not exists project
(
    id         uuid primary key,
    name       text        not null,
    created_at timestamptz not null,
    updated_at timestamptz not null,

    constraint uq_project_name unique (name)
);

create table if not exists todo
(
    id          uuid primary key,
    project_id  uuid        not null,
    title       text        not null,
    description text,
    status      text        not null,
    due_date    date,
    created_at  timestamptz not null,
    updated_at  timestamptz not null,

    constraint fk_todo_project_id foreign key (project_id) references project (id),

    constraint ck_todo_status check ( status IN ('TODO', 'IN_PROGRESS', 'DONE') )
);

create index if not exists ix_todo_project_id on todo (project_id);

create index if not exists ix_todo_project_id_status on todo (project_id, status);