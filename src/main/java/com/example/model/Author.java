
package com.example.model;

// Represents the author entity.
public class Author {
    private int id;
    private String name;
    private String biography;

    public Author() {}

    public Author(int id, String name, String biography) {
        this.id = id;
        this.name = name;
        this.biography = biography;
    }

    // Returns authors id
    public int getId() { return id; }
    // Sets author id
    public void setId(int id) { this.id = id; }

    // Returns authors name.
    public String getName() { return name; }
    // Sets authors name.
    public void setName(String name) { this.name = name; }

    // Returns authors biography
    public String getBiography() { return biography; }
    // Sets authors biography.
    public void setBiography(String biography) { this.biography = biography; }
}
