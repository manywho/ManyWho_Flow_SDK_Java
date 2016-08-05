package com.manywho.sdk.services.types.system;

import com.manywho.sdk.enums.ContentType;
import com.manywho.sdk.services.annotations.TypeElement;
import com.manywho.sdk.services.annotations.TypeProperty;
import org.joda.time.DateTime;

@TypeElement(name = "$File")
public class $File {
    @TypeProperty(name = "Date Created", contentType = ContentType.DateTime)
    private DateTime dateCreated;

    @TypeProperty(name = "Date Modified", contentType = ContentType.DateTime)
    private DateTime dateModified;

    @TypeProperty(name = "Description", contentType = ContentType.String)
    private String description;

    @TypeProperty(name = "Download Uri", contentType = ContentType.String)
    private String downloadUri;

    @TypeProperty(name = "Embed Uri", contentType = ContentType.String)
    private String embedUri;

    @TypeProperty(name = "Icon Uri", contentType = ContentType.String)
    private String iconUri;

    @TypeProperty(name = "Id", contentType = ContentType.String)
    private String id;

    @TypeProperty(name = "Kind", contentType = ContentType.String)
    private String kind;

    @TypeProperty(name = "Mime Type", contentType = ContentType.String)
    private String mimeType;

    @TypeProperty(name = "Name", contentType = ContentType.String)
    private String name;

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public DateTime getDateModified() {
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
