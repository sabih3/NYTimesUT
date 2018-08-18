package com.nytimes.sabihahmed.nytimes.network.model.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseNews {
    private String status;
    private String copyright;
    private int num_results;
    private List<Result> results;

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public int getNum_results() {
        return num_results;
    }

    public List<Result> getResults() {
        return results;
    }

    public class Result {
        public String url;
        public String adx_keywords;
        public Object column;
        public String section;
        public String byline;
        public String type;
        public String title;

        @SerializedName("abstract")
        public String Abstract;

        public String published_date;
        public String source;
        public long id;
        public long asset_id;
        public int views;
        public List<String> des_facet;
        public Object org_facet;
        public Object per_facet;
        public Object geo_facet;
        public List<Medium> media;

        public String getUrl() {
            return url;
        }

        public String getAdx_keywords() {
            return adx_keywords;
        }

        public Object getColumn() {
            return column;
        }

        public String getSection() {
            return section;
        }

        public String getByline() {
            return byline;
        }

        public String getType() {
            return type;
        }

        public String getTitle() {
            return title;
        }

        public String getAbstract() {
            return Abstract;
        }

        public String getPublished_date() {
            return published_date;
        }

        public String getSource() {
            return source;
        }

        public long getId() {
            return id;
        }

        public long getAsset_id() {
            return asset_id;
        }

        public int getViews() {
            return views;
        }

        public List<String> getDes_facet() {
            return des_facet;
        }

        public Object getOrg_facet() {
            return org_facet;
        }

        public Object getPer_facet() {
            return per_facet;
        }

        public Object getGeo_facet() {
            return geo_facet;
        }

        public List<Medium> getMedia() {
            return media;
        }

        public class Medium {
            public String type;
            public String subtype;
            public String caption;
            public String copyright;
            public int approved_for_syndication;

            @SerializedName("media-metadata")
            public List<MediaMetadata> media_metadata;

            public class MediaMetadata{
                public String url;
                public String format;
                public int height;
                public int width;


                public String getUrl() {
                    return url;
                }

                public String getFormat() {
                    return format;
                }

                public int getHeight() {
                    return height;
                }

                public int getWidth() {
                    return width;
                }
            }

            public String getType() {
                return type;
            }

            public String getSubtype() {
                return subtype;
            }

            public String getCaption() {
                return caption;
            }

            public String getCopyright() {
                return copyright;
            }

            public int getApproved_for_syndication() {
                return approved_for_syndication;
            }

            public List<MediaMetadata> getMedia_metadata() {
                return media_metadata;
            }
        }
    }
}
