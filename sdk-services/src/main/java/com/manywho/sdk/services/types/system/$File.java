package com.manywho.sdk.services.types.system;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

import java.time.OffsetDateTime;

@Type.Element(name = "$File")
public class $File implements Type {
    @Type.Property(name = "Date Created", contentType = ContentType.DateTime)
    private OffsetDateTime dateCreated;

    @Type.Property(name = "Date Modified", contentType = ContentType.DateTime)
    private OffsetDateTime dateModified;

    @Type.Property(name = "Description", contentType = ContentType.String)
    private String description;

    @Type.Property(name = "Download Uri", contentType = ContentType.String)
    private String downloadUri;

    @Type.Property(name = "Embed Uri", contentType = ContentType.String)
    private String embedUri;

    @Type.Property(name = "Icon Uri", contentType = ContentType.String)
    private String iconUri;

    @Type.Identifier
    @Type.Property(name = "Id", contentType = ContentType.String)
    private String id;

    @Type.Property(name = "Kind", contentType = ContentType.String)
    private String kind;

    @Type.Property(name = "Mime Type", contentType = ContentType.String)
    private String mimeType;

    @Type.Property(name = "Name", contentType = ContentType.String)
    private String name;

    public $File(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public $File() {

    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public OffsetDateTime getDateModified() {
        return dateModified;
    }

    public String getDescription() {
        return description;
    }

    public String getDownloadUri() {
        return downloadUri;
    }

    public String getEmbedUri() {
        return embedUri;
    }

    public String getIconUri() {
        return iconUri;
    }

    public String getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getName() {
        return name;
    }
}
