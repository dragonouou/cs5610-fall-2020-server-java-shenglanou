(function () {
    let users = [
        {
            username: 'alice',
            fName: 'Alice',
            lName: 'Wonderland',
            role: 'Faculty'
        },
        {
            username: 'bob',
            fName: 'Robert',
            lName: 'Marley',
            role: 'Faculty'
        },
        {
            username: 'charlie',
            fName: 'Charlie',
            lName: 'Garcia',
            role: 'Student'
        }
    ]

    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    $(main);

    function main() {
        $usernameFld = $("#usernameFld")
        $passwordFld = $("#passwordFld")
        $firstNameFld = $("#firstNameFld")
        $lastNameFld = $("#lastNameFld")
        $roleFld = $("#roleFld")
        $userRowTemplate = $("tr.wbdv-template")
        $tbody = $("tbody")

        // $removeBtn = $(".wbdv-remove").click(deleteUser)
        $editBtn = $(".wbdv-edit")
        $createBtn = $(".wbdv-create").click(createUser)
        renderUsers(users)
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
            fName: firstname,
            lName: lastname,
            role: role
        }

        users.push(newUser)
        renderUsers(users)
    }

    function findAllUsers() {

    }

    function findUserById() {}

    function deleteUser(index) {
        users.splice(index,1)
        renderUsers(users)
    }

    function selectUser() {}

    function updateUser() {

    }
    function renderUser(user) {}

    function renderUsers(users) {
        $tbody.empty()
        for (let i = 0;i < users.length; i++){
            const user = users[i]
            const clone = $userRowTemplate.clone()
            clone.find(".wbdv-username").html(user.username)
            clone.find(".wbdv-first-name").html(user.fName)
            clone.find(".wbdv-last-name").html(user.lName)
            clone.find(".wbdv-role").html(user.role)

            $removeBtn = clone.find(".wbdv-remove").click(() => deleteUser(i))

            $tbody.append(clone)
        }

    }
})()