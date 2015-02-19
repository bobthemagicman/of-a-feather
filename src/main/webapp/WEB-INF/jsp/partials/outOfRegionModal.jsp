<div class="outside-beta-region-modal modal fade"> 
    <div class="modal-dialog"> 
        <div class="modal-content"> 
            <div class="modal-header"> 
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> 
                <h4 class="modal-title">We&apos;re Sorry!</h4> 
            </div> 
            <div id="outside-beta-region-modal-body" class="modal-body"> 
                <p>We currently only have churches in the greater San Francisco area in our database.<br />
                   Please enter your email address to be notified when we expand to ${errorSearchTerm}.</p> 
                <form class="form-inline" role="form" id="email-submit-form"> 
                    <div class="form-group"> 
                        <input type="text" id="email-address" placeholder="Your email address." class="form-control" />
                        <input type="hidden" id="user-key" value="${userKey}" /> 
                        <input type="hidden" id="user-search-city" value="${errorSearchTerm}" />
                    </div> 
                    <button type="submit" class="btn btn-primary">Submit</button> 
                </form>       
            </div> 
            <div class="modal-footer"> Click <a href="'+resourceBaseURL+'../privacyPolicy">here</a> to view our privacy policy. </div> 
        </div>
    </div>
</div>