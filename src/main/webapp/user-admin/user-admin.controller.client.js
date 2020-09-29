(function () {
    let users = []
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn, $updateBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    $(main);

    function main() {
        findAllUsers()

        $usernameFld = $("#usernameFld")
        $passwordFld = $("#passwordFld")
        $firstNameFld = $("#firstNameFld")
        $lastNameFld = $("#lastNameFld")
        $roleFld = $("#roleFld")
        $userRowTemplate = $("tr.wbdv-template")
        $tbody = $("tbody")

        $createBtn = $(".wbdv-create").click(createUser)
        $updateBtn = $(".wbdv-update").click(updateUser)
    }

    function createUser() {
        const username = $usernameFld.val()
        const firstname = $firstNameFld.val()
        const lastname = $lastNameFld.val()
        const role = $roleFld.val()
        $usernameFld.val("")
        $firstNameFld.val("")
        $lastNameFld.val("")
        $roleFld.val("")
        const newUser = {
            username: username,
            first: firstname,
            last: lastname,
            role: role
        }
        userService.createUser(newUser)
            .then(newUserOnServer => {
            users.push(newUserOnServer)
            renderUsers(users)
        })
    }

    function findAllUsers() {
        userService.findAllUsers()
            .then(data => {
                users = data
                renderUsers(users)
            })
    }

    let foundUser
    function findUserById(userId) {
        userService.findUserById(userId)
            .then(user => {
                foundUser = user
            })
    }

    function deleteUser(index) {
        const user = users[index]
        const userId = user._id
        userService.deleteUser(userId)
            .then(response => {
                users.splice(index,1)
                renderUsers(users)
            })
    }

    let selectedUserIndex = -1
    function selectUser(_index) {
        selectedUserIndex = _index
        $("#usernameFld").val(users[_index].username)
        $("#firstNameFld").val(users[_index].first)
        $("#lastNameFld").val(users[_index].last)
        $("#roleFld").val(users[_index].role)
    }

    function updateUser() {
        const newUsername = $usernameFld.val()
        const newFirstname = $firstNameFld.val()
        const newLastname = $lastNameFld.val()
        const newRole = $roleFld.val()
        $usernameFld.val("")
        $firstNameFld.val("")
        $lastNameFld.val("")
        $roleFld.val("")

        const userId = users[selectedUserIndex]._id
        userService.updateUser(userId,{
            username: newUsername,
            first: newFirstname,
            last: newLastname,
            role: newRole
        })
            .then(response => {
                users[selectedUserIndex].username = newUsername
                users[selectedUserIndex].first = newFirstname
                users[selectedUserIndex].last = newLastname
                users[selectedUserIndex].role = newRole
                // renderUser(users[selectedUserIndex])
                renderUsers(users)
            })
    }

    let userIndex = -1
    function renderUser(user) {
        for(let i = 0;i < users.length; i++){
            if (users[i]._id === user._id){
                // one template row is hidden
                userIndex = i + 1
                break
            }
        }
        let $userElement = $("tr.wbdv-template:nth-child("+ userIndex + ")")
        $userElement.find(".wbdv-username").html(user.username)
        $userElement.find(".wbdv-first-name").html(user.first)
        $userElement.find(".wbdv-last-name").html(user.last)
        $userElement.find(".wbdv-role").html(user.role)
    }

    function renderUsers(users) {
        $tbody.empty()
        for (let i = 0;i < users.length; i++){
            const user = users[i]
            const clone = $userRowTemplate.clone()
            clone.removeClass("wbdv-hidden")
            clone.find(".wbdv-username").html(user.username)
            clone.find(".wbdv-first-name").html(user.first)
            clone.find(".wbdv-last-name").html(user.last)
            clone.find(".wbdv-role").html(user.role)
            $removeBtn = clone.find(".wbdv-remove").click(() => deleteUser(i))
            $editBtn = clone.find(".wbdv-edit").click(() => selectUser(i))
            $tbody.append(clone)
        }
    }
})()