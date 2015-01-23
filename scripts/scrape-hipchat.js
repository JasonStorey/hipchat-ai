var messages = [];

var rows = document.querySelectorAll('.hc-chat-row.hc-msg-nocolor');

[].forEach.call(rows, function(row) {
    var message,
        name = row.querySelector('.hc-chat-from'),
        content = row.querySelector('.hc-chat-msg div'),
        time = row.querySelector('a');

    if(name && content && time) {
        message = {
            name: name.innerHTML,
            content: content.innerHTML,
            time: time.getAttribute('name')
        };
        messages.push(message);
    }
});

console.log(JSON.stringify(messages));