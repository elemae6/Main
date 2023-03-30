$('#exampleModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var recipient = button.data('whatever') // Extract info from data-* attributes
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  var modal = $(this)
  modal.find('.modal-title').text('New message to ' + recipient)
  modal.find('.modal-body input').val(recipient)
})

{
    const commentCreateBtn = document.querySelector("#review-write-btn");
    commentCreateBtn.addEventListener("click", function() {
    alert("a");
//    const review = {
//                name:document.querySelector("#review-write-name").value,
//                content:document.querySelector("#review-write-message").value
//            };
//        const url = `/shop`;
//        fetch(url, {
//            method: 'POST',
//            body: JSON.stringify(review),
//            headers: {
//                "Content-Type": "application/json"
//            }
//        }).then(response => {
//        alert("b");
//            const msg = (response.ok) ? "리뷰가 작성되었습니다." : "다시 작성해주시기 바랍니다.";
//            alert(msg);
//
//        });
    });
}
