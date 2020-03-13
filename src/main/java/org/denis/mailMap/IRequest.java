package org.denis.mailMap;

interface IRequest<T> {
    String getFrom();
    String getTo();
    T getContent();
}
