package com.manywho.sdk.services.types.system;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.values.Value;

import java.time.OffsetDateTime;

@Type.Element(name = "$File")
public class $File implements Type {
    @Value.Property(name = "Date Created", contentType = ContentType.DateTime)
    private OffsetDateTime dateCreated;

    @Value.Property(name = "Date Modified", contentType = ContentType.DateTime)
    private OffsetDateTime dateModified;

    @Value.Property(name = "Description", contentType = ContentType.String)
    private String description;

    @Value.Property(name = "Download Uri", contentType = ContentType.String)
    private String downloadUri;

    @Value.Property(name = "Embed Uri", contentType = ContentType.String)
    private String embedUri;

    @Value.Property(name = "Icon Uri", contentType = ContentType.String)
    private String iconUri;

    @Type.Identifier
    @Value.Property(name = "Id", contentType = ContentType.String)
    private String id;

    @Value.Property(name = "Kind", contentType = ContentType.String)
    private String kind;

    @Value.Property(name = "Mime Type", contentType = ContentType.String)
    private String mimeType;

    @Value.Property(name = "Name", contentType = ContentType.String)
    private String name;

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
