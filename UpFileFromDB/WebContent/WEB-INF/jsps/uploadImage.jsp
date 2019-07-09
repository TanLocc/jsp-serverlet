<!DOCTYPE >
<html>
<head>
<title>Upload files</title>
</head>
<body>
 
    <div style="padding:5px; color:red;font-style:italic;">
       ${errorMessage}
    </div>
    
    <h2>Upload Image</h2>
 
    <form method="post" action="${pageContext.request.contextPath}/uploadImageToDB"
        enctype="multipart/form-data">
        
        Select file to upload:
        <br />
        <input type="file" name="image1"  />
        <br />
        <input type="file" name="image2" />
        <br />
        Description:
        <br />
       
        <br />
        <input type="submit" value="Upload" />
    </form>
    
</body>
</html>