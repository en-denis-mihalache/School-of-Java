package com.example.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * This is the book model
 */

@Schema(name = "Book", description = "This is the book model")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T14:35:26.798085400+02:00[Europe/Bucharest]", comments = "Generator version: 7.8.0")
public class Book {

  private String name;

  private String bookAuthor;

  public Book name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of book
   * @return name
   */
  
  @Schema(name = "name", description = "The name of book", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Book bookAuthor(String bookAuthor) {
    this.bookAuthor = bookAuthor;
    return this;
  }

  /**
   * name of author
   * @return bookAuthor
   */
  
  @Schema(name = "bookAuthor", description = "name of author", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bookAuthor")
  public String getBookAuthor() {
    return bookAuthor;
  }

  public void setBookAuthor(String bookAuthor) {
    this.bookAuthor = bookAuthor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(this.name, book.name) &&
        Objects.equals(this.bookAuthor, book.bookAuthor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, bookAuthor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Book {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    bookAuthor: ").append(toIndentedString(bookAuthor)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

