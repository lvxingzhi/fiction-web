package com.note.fictionweb.aspect;

/**
 * Created by Administrator on 2017/7/23.
 */
//@ControllerAdvice
public class ExceptionAspect {

//    private Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);
//
//    //比如404的异常就会被这个方法捕获
//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String handle404Error(HttpServletRequest req, HttpServletResponse rsp, Exception e) throws Exception {
//        return JsonUtil.toJson(dualException(e));
//
//    }
//
//    //500的异常会被这个方法捕获
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public String handleError(HttpServletRequest req, HttpServletResponse rsp, Exception e) throws Exception {
//        return JsonUtil.toJson(dualException(e));
//    }
//
//    private ResponseDTO dualException(Exception e){
//        logger.error(e.getMessage(),e);
//        ResponseDTO responseDTO = ResponseDTO.getErrorInstance();
//        return responseDTO;
//    }


}
