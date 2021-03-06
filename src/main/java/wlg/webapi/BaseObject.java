package wlg.webapi;

import wlg.apiutil.Util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Provides some convenient method implementations. Other object can extend it
 * to leverage these methods.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class BaseObject {
  /**
   * A JSON representation of the object.
   */
  @Override
  public String toString() {
    return Util.toJson(this);
  }
}
